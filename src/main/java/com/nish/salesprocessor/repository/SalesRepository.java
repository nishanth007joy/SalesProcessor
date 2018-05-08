package com.nish.salesprocessor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nish.salesprocessor.model.SaleDetails;

/**
 * Repository to access Sales details entity
 * 
 * @author n.mathew.joy
 *
 */
@Repository
public interface SalesRepository extends JpaRepository<SaleDetails, Long> {
	/**
	 * This will get all sales with specified name
	 * 
	 * @param salesName
	 * @return
	 */
	public Optional<List<SaleDetails>> findBySalesName(String salesName);

	/**
	 * Find all sale details in ascending order by id
	 * @return
	 */
	public Optional<List<SaleDetails>> findAllByOrderByIdAsc();

}
