package com.SofwareVision.supermercado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SofwareVision.supermercado.Models.Stock;

public interface CompraRepository extends JpaRepository<Stock, Long> {

}
