package com.nish.salesprocessor.api.contract;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nish.salesprocessor.bo.SaleDetailsBO;
import com.nish.salesprocessor.bo.SalesAdjustmentBO;
import com.nish.salesprocessor.response.Message;
/**
 * Api contract for sale processor
 * @author n.mathew.joy
 *
 */
public interface SalesContract {
	/**
	 * This method saves sales details send by a client
	 * 
	 * @param saleDetailsBO
	 * @return
	 */
	public ResponseEntity<Message> saveSalesDetails(SaleDetailsBO saleDetailsBO);

	/**
	 * retrives all sales saved in system so far and this is designed in
	 * expecting max 50 sales details as use case is like that
	 * 
	 * @return
	 */
	public ResponseEntity<List<SaleDetailsBO>> getAllSales();

	/**
	 * 
	 * @param salesAdjustmentBO
	 * @return
	 */
	public ResponseEntity<Message> saveSalesDetails(SalesAdjustmentBO salesAdjustmentBO);

}
