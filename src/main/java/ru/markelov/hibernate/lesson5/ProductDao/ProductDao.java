package ru.markelov.hibernate.lesson5.ProductDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.markelov.hibernate.lesson5.model.Product;

import java.util.List;

public class ProductDao {
    private static SessionFactory factory;

    public static void main(String[] args) {
        init();
        saveProduct("Meat", 90);
//        getProduct(1);
//        updateProduct(1, "Apple", 40);
//        removeProduct(6);
//        findAll();

        shutDown();
    }

    public static void init(){
        factory = new Configuration().configure("ProductDao/hibernate.conf.xml").buildSessionFactory();
    }

    public static void saveProduct(String name, int cost){
        try (Session session = factory.getCurrentSession();){
            session.beginTransaction();
            Product product = new Product(name, cost);
            session.save(product);
            System.out.println(product);
            session.getTransaction().commit();
            System.out.println(product);
        }
    }

    public static void getProduct(int id){
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }

    public static void updateProduct(int id, String name){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        System.out.println(product);
        product.setName(name);
        System.out.println(product);
        session.getTransaction().commit();
        System.out.println(product);
    }

    public static void updateProduct(int id, int cost){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        System.out.println(product);
        product.setCost(cost);
        System.out.println(product);
        session.getTransaction().commit();
        System.out.println(product);
    }

    public static void updateProduct(int id, String name, int cost){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        System.out.println(product);
        product.setName(name);
        System.out.println(product);
        product.setCost(cost);
        System.out.println(product);
        session.getTransaction().commit();
        System.out.println(product);
    }

    public static void findAll(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            List<Product> productLis = session.createQuery("select p from Product p").getResultList();
            System.out.println(productLis.toString());
            session.getTransaction().commit();
        }
    }

    public static void removeProduct(int id){
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            session.remove(product);
            System.out.println(product);
            session.getTransaction().commit();
            System.out.println(product);
        }
    }

    public static void  shutDown(){
        factory.close();
    }
}
