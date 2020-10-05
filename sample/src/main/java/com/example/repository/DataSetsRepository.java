package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.DataSets;

/**
 * @author Vkhandelwal
 */

@Repository
@Transactional(readOnly = true)
public interface DataSetsRepository extends JpaRepository<DataSets, Integer> {
	
	@Query("select ds from DataSets ds where ds.stock = ?1")
    public List<DataSets> findByStockTicker(String stockTicker); 
	
	@Query("select ds from DataSets ds where ds.quarter = ?1 AND ds.stock = ?2 and ds.date = ?3")
    public DataSets findByQuarterAndStockAndDate(Integer quarter, String stock, String date);
}
