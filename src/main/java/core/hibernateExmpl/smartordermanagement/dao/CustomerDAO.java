package core.hibernateExmpl.smartordermanagement.dao;

import core.hibernateExmpl.smartordermanagement.entity.Customer;
import core.hibernateExmpl.smartordermanagement.entity.Order;
import core.hibernateExmpl.smartordermanagement.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CustomerDAO {

    private static final EntityManager manager = JPAUtil.getEntityManager();

    public boolean save(Customer customer) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    public Customer find(Long id) {
        return manager.find(Customer.class, id);
    }

    public boolean delete(long id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            Customer customer = find(id);
            if (customer == null) return false;
            transaction.begin();
            manager.remove(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            return false;
        }
    }

    public List<Order> getOrdersByCustomerId(Long id) {
        try {
            Customer customer = find(id);
            return customer != null ? customer.getOrders() : null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Customer> findAll() {
        try {
            TypedQuery<Customer> query = manager.createQuery("SELECT c FROM Customer c", Customer.class);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
