package com.ElectronicStore.com.fifth.Service;

import com.ElectronicStore.com.fifth.Entity.Product;
import org.springframework.stereotype.Service;

import  java.util.*;

@Service
public interface StoreService {
    public List<Product> findAll();
    public void save(Product product);
    public void deleteById(Long id);
    public Product findById(Long id);
}
