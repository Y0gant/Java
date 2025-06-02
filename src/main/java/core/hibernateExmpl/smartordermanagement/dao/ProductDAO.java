package core.hibernateExmpl.smartordermanagement.dao;

import core.hibernateExmpl.smartordermanagement.entity.Product;
import core.hibernateExmpl.smartordermanagement.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductDAO {

    private static final EntityManager manager = JPAUtil.getEntityManager();

    public boolean save(Product p) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(p);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Error saving product: " + e.getMessage());
            return false;
        }
    }

    public Product findById(long id) {
        return manager.find(Product.class, id);
    }

    public boolean delete(long id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            Product p = findById(id);
            if (p == null) return false;
            transaction.begin();
            manager.remove(p);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("Error deleting product: " + e.getMessage());
            return false;
        }
    }

    public List<Product> findAll() {
        try {
            TypedQuery<Product> query = manager.createQuery("SELECT p FROM Product p", Product.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Error retrieving products: " + e.getMessage());
            return null;
        }
    }
}
