package com.supplier.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supplier.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	List<Supplier> findBySupplierName(String name);
	List<Supplier> findBySupplierCity(String city);
}
