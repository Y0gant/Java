package core.hibernateExmpl.smartordermanagement;

import core.hibernateExmpl.smartordermanagement.dao.CustomerDAO;
import core.hibernateExmpl.smartordermanagement.dao.OrderDAO;
import core.hibernateExmpl.smartordermanagement.dao.ProductDAO;
import core.hibernateExmpl.smartordermanagement.entity.Customer;
import core.hibernateExmpl.smartordermanagement.entity.Order;
import core.hibernateExmpl.smartordermanagement.entity.OrderItem;
import core.hibernateExmpl.smartordermanagement.entity.Product;
import core.hibernateExmpl.smartordermanagement.utils.JPAUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerDAO customerDAO = new CustomerDAO();
    private static final ProductDAO productDAO = new ProductDAO();
    private static final OrderDAO orderDAO = new OrderDAO();

    public static void main(String[] args) {

        System.out.println("===== SMART ORDER MANAGEMENT SYSTEM =====");

        while (true) {
            System.out.println("""
                    \nMENU:
                    1. Add Customer
                    2. Add Product
                    3. Place Order
                    4. View Customer Orders
                    5. View all customers
                    6. Exit
                    Enter your choice:
                    """);

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addCustomer();
                case 2 -> addProduct();
                case 3 -> placeOrder();
                case 4 -> viewCustomerOrders();
                case 5 -> viewCustomers();
                case 6 -> {
                    JPAUtil.close();
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewCustomers() {
        System.out.println(customerDAO.findAll());
    }

    private static void addCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);

        boolean saved = customerDAO.save(customer);
        System.out.println(saved ? "Customer added." : "Failed to add customer.");
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(name, price);
        boolean saved = productDAO.save(product);
        System.out.println(saved ? "Product added." : "Failed to add product.");
    }

    private static void placeOrder() {
        System.out.print("Enter customer ID: ");
        long customerId = Long.parseLong(scanner.nextLine());

        Customer customer = customerDAO.find(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(java.time.LocalDate.now().toString());
        List<OrderItem> items = new ArrayList<>();

        while (true) {
            System.out.print("Enter product ID (or 0 to finish): ");
            System.out.println(productDAO.findAll());
            long productId = Long.parseLong(scanner.nextLine());
            if (productId == 0) break;

            Product product = productDAO.findById(productId);
            if (product == null) {
                System.out.println("Product not found.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(scanner.nextLine());

            OrderItem item = new OrderItem(product, order, qty);
            items.add(item);
        }

        order.setItems(items);
        if (order.getItems().isEmpty()) {
            System.out.println("Failed to place order.");
            return;
        }
        boolean saved = orderDAO.save(order);
        System.out.println(saved ? "Order placed." : "Failed to place order.");
    }

    private static void viewCustomerOrders() {
        System.out.print("Enter customer ID: ");
        long customerId = Long.parseLong(scanner.nextLine());

        Customer customer = customerDAO.find(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        List<Order> orders = orderDAO.getOrdersForCustomer(customer);
        if (orders == null || orders.isEmpty()) {
            System.out.println("No orders found for this customer.");
            return;
        }

        for (Order o : orders) {
            System.out.println("\nOrder ID: " + o.getId());
            System.out.println("Date: " + o.getOrderDate());
            System.out.println("Total: ₹" + o.getTotalAmount());

            for (OrderItem item : o.getItems()) {
                System.out.printf(" - %s x %d = ₹%.2f\n",
                        item.getProduct().getName(),
                        item.getQuantity(),
                        item.getProduct().getPrice() * item.getQuantity());
            }
        }
    }
}
