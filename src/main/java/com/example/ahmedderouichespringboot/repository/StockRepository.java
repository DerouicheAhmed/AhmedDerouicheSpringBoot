package com.example.ahmedderouichespringboot.repository;

import com.example.ahmedderouichespringboot.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
