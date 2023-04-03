package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> list(String search) {
        if (search == null) {
            search = "";
        }
        List<Product> list = BaseRepository.entityManager.createQuery("select s from Product s where name like '%" + search + "%' ", Product.class).getResultList();
        return list;
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void update(int id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.createQuery("update Product p set p.name=:name,p.price=:price," +
                        "p.description=:description,p.producer=:producer where p.id=:id")
                .setParameter("name", product.getName()).setParameter("price", product.getPrice())
                .setParameter("description", product.getDescription())
                .setParameter("producer", product.getProducer()).getSingleResult();
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.createQuery("delete from Product where id=id", Product.class);
        entityTransaction.commit();
    }

    @Override
    public Product findByID(int id) {
        return BaseRepository.entityManager.find(Product.class, id);

    }
}
