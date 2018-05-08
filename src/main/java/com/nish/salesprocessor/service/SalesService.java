package com.nish.salesprocessor.service;

import java.util.List;

import com.nish.salesprocessor.bo.SaleDetailsBO;
import com.nish.salesprocessor.bo.SalesAdjustmentBO;

/**
 * Sales service contains all methods to handle sales
 * 
 * @author n.mathew.joy
 *
 */
public interface SalesService {
	/**
	 * This method returns true if specified number of messages are already processed and otherwise false
	 * @param numberOfMessages
	 * @return
	 */
	public boolean isSpecifiedMessageProcessed(long numberOfMessages);
	/**
	 * Save sales information to db
	 * @param saleDetailsBO
	 */
	public void saveSalesDetails(SaleDetailsBO saleDetailsBO);

	/**
	 * get all sales information from db
	 * @return
	 */
	public List<SaleDetailsBO> getAllSalesDetails();

	/**
	 * save sale adjustment instruction
	 * @param salesAdjustmentBO
	 */
	public void saveSalesAdjustment(SalesAdjustmentBO salesAdjustmentBO);
}
