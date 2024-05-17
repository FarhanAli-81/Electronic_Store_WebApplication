package com.ElectronicStore.com.fifth.Service;

import com.ElectronicStore.com.fifth.Entity.Product;
import com.ElectronicStore.com.fifth.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements  StoreService{

    @Autowired
    private StoreRepository storeRepository;


    @Override
    public List<Product> findAll(){
        return storeRepository.findAll();

    }

    @Override
    public void save(Product product){
        storeRepository.save(product);
    }

    @Override
    public void deleteById(Long id){
        storeRepository.deleteById(id);
    }
    @Override
    public Product findById(Long id){
        return storeRepository.findById(id).get();
    }
}
