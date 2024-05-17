package com.ElectronicStore.com.fifth.Repository;

import com.ElectronicStore.com.fifth.Entity.Product;
//import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository
public interface StoreRepository extends JpaRepository<Product, Long > {
}
