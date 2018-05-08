package com.nish.salesprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nish.salesprocessor.model.PriceAdjustReport;

/**
 * Repository to access Sales adjustment report
 * 
 * @author n.mathew.joy
 *
 */
@Repository
public interface PriceAdjustReportRepository extends JpaRepository<PriceAdjustReport, Long> {

}
