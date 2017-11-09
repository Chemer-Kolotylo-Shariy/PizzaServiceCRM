package com.pizza.project.service.impl;

import com.pizza.project.dao.ProductDao;
import com.pizza.project.model.Product;
import com.pizza.project.service.ProductServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServise {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.get(id);
    }

    @Override
    public Long create(Product product) {
        return productDao.create(product);
    }

    @Override
    @Transactional
    public List<Product> getProductByCategory(String category) {
        if (category == null){
            return null;
        }
        return productDao.getProductsByCategoryAndAmountNotNull(category);
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        return productDao.remove(id);
    }

    @Override
    public Long update(Product product) {
        return productDao.update(product);
    }
}
