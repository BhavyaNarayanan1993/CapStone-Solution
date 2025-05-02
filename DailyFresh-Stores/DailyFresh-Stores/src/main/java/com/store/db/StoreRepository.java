package com.store.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.model.Stores;

@Repository
public interface StoreRepository extends JpaRepository<Stores, Integer>{

}
