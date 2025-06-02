package core.hibernateExmpl.smartordermanagement.dao;

import core.hibernateExmpl.smartordermanagement.entity.Customer;
import core.hibernateExmpl.smartordermanagement.entity.Order;
import core.hibernateExmpl.smartordermanagement.entity.OrderItem;
import core.hibernateExmpl.smartordermanagement.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrderDAO {

    private static final EntityManager manager = JPAUtil.getEntityManager();

    public boolean save(Order o) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            double total = 0.0;
            for (OrderItem item : o.getItems()) {
                item.setOrder(o);
                total += item.getProduct().getPrice() * item.getQuantity();
            }
            o.setTotalAmount(total);

            manager.persist(o);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Error saving order: " + e.getMessage());
            return false;
        }
    }

    public Order findById(long id) {
        return manager.find(Order.class, id);
    }

    public boolean delete(long id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            Order o = findById(id);
            if (o == null) return false;

            transaction.begin();
            manager.remove(o);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Error deleting order: " + e.getMessage());
            return false;
        }
    }

    public List<Order> getOrdersForCustomer(Customer customer) {
        try {
            TypedQuery<Order> query = manager.createQuery(
                    "SELECT o FROM Order o WHERE o.customer = :customer", Order.class);
            query.setParameter("customer", customer);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error fetching orders: " + e.getMessage());
            return null;
        }
    }
}
