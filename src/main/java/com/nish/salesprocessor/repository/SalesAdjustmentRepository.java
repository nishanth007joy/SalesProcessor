package com.nish.salesprocessor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nish.salesprocessor.model.SalesAdjustment;

/**
 * Repository to deal with sale adjustments
 * @author n.mathew.joy
 *
 */
@Repository
public interface SalesAdjustmentRepository extends JpaRepository<SalesAdjustment, Long> {

}
