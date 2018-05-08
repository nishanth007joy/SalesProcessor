package com.nish.salesprocessor.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nish.salesprocessor.api.contract.SalesContract;
import com.nish.salesprocessor.bo.SaleDetailsBO;
import com.nish.salesprocessor.bo.SalesAdjustmentBO;
import com.nish.salesprocessor.response.Message;
import com.nish.salesprocessor.service.ReportService;
import com.nish.salesprocessor.service.SalesService;

/**
 * This is the controller class for sales service api
 * 
 * @author n.mathew.joy
 *
 */
@RestController
@RequestMapping("/sales")
public class SalesController implements SalesContract {
	@Autowired
	private SalesService salesService;

	@Autowired
	private ReportService reportService;

	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveSalesDetails(@Valid @RequestBody SaleDetailsBO saleDetailsBO) {
		if(!salesService.isSpecifiedMessageProcessed(50)){
		salesService.saveSalesDetails(saleDetailsBO);
		reportService.generateReport();
		return new ResponseEntity<Message>(Message.builder().msgCode("201").msgDesc("Record inserted").build(),
				HttpStatus.CREATED);
		}else{
			return new ResponseEntity<Message>(Message.builder().msgCode("406").msgDesc("Message cant be accepted").build(),
					HttpStatus.NOT_ACCEPTABLE);
		}
		
	}

	@Override
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SaleDetailsBO>> getAllSales() {
		return new ResponseEntity<List<SaleDetailsBO>>(salesService.getAllSalesDetails(), HttpStatus.OK);
	}

	@Override
	@PostMapping(path = "/operation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> saveSalesDetails(@Valid @RequestBody SalesAdjustmentBO salesAdjustmentBO) {
		if(!salesService.isSpecifiedMessageProcessed(50)){
		salesService.saveSalesAdjustment(salesAdjustmentBO);
		reportService.generateReport();
		return new ResponseEntity<Message>(Message.builder().msgCode("201").msgDesc("Record inserted").build(),
				HttpStatus.CREATED);
		}else{
			return new ResponseEntity<Message>(Message.builder().msgCode("406").msgDesc("Message cant be accepted").build(),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
