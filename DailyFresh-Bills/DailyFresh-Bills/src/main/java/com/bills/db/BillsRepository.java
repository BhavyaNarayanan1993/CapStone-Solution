package com.bills.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bills.model.Bill;

@Repository
public interface BillsRepository extends JpaRepository<Bill, Integer>{

}
