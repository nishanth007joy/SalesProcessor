package com.nish.salesprocessor.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.salesprocessor.bo.SaleDetailsBO;
import com.nish.salesprocessor.bo.SalesAdjustmentBO;
import com.nish.salesprocessor.exception.SalesProcessorException;
import com.nish.salesprocessor.mapper.SalesDetailsMapper;
import com.nish.salesprocessor.model.PriceAdjustReport;
import com.nish.salesprocessor.model.SaleDetails;
import com.nish.salesprocessor.model.SalesAdjustment;
import com.nish.salesprocessor.repository.PriceAdjustReportRepository;
import com.nish.salesprocessor.repository.SalesAdjustmentRepository;
import com.nish.salesprocessor.repository.SalesRepository;
import com.nish.salesprocessor.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService {
	private static final Logger log = LoggerFactory.getLogger(SalesServiceImpl.class);
	@Autowired
	private SalesRepository salesRepository;

	@Autowired
	private PriceAdjustReportRepository priceAdjustReportRepository;

	@Autowired
	private SalesAdjustmentRepository salesAdjustmentRepository;

	private SalesDetailsMapper salesDetailsMapper = SalesDetailsMapper.instance;
	
	@Override
	public void saveSalesDetails(SaleDetailsBO saleDetailsBO) {
		SaleDetails saleDetails = salesDetailsMapper.salesDetailsBOToSalesDetailsEntity(saleDetailsBO);
		salesRepository.save(saleDetails);
	}

	@Override
	public List<SaleDetailsBO> getAllSalesDetails() {
		List<SaleDetails> salesDetails = salesRepository.findAll();
		return salesDetailsMapper.salesDetailsEntityListToSalesDetailsBOList(salesDetails);
	}

	@Override
	@Transactional
	public void saveSalesAdjustment(SalesAdjustmentBO salesAdjustmentBO) {
		SalesAdjustment salesAdjustment = SalesDetailsMapper.instance
				.salesAdjustmentBOToSalesAdjustmentEntity(salesAdjustmentBO);
		salesAdjustmentRepository.save(salesAdjustment);
		Optional<List<SaleDetails>> salesDetails = salesRepository.findBySalesName(salesAdjustmentBO.getSalesName());
		if (salesDetails.isPresent()) {
			switch (salesAdjustment.getOperation()) {
			case ADD:
				salesDetails.get().stream().forEach(sale -> {
					StringBuilder priceChanegReport = new StringBuilder("ADD operation on ").append(sale.getSalesName())
							.append(" price change from").append(sale.getPrice());
					sale.setPrice(sale.getPrice().add(salesAdjustment.getOperationAmount()));
					priceAdjustReportRepository.save(PriceAdjustReport.builder()
							.reportText(priceChanegReport.append(" to ").append(sale.getPrice()).toString()).build());
				});
				break;
			case SUBTRACT:
				salesDetails.get().stream().forEach(sale -> {
					StringBuilder priceChanegReport = new StringBuilder("SUBTRACT operation on ")
							.append(sale.getSalesName()).append(" price change from").append(sale.getPrice());
					sale.setPrice(sale.getPrice().subtract(salesAdjustment.getOperationAmount()));
					priceAdjustReportRepository.save(PriceAdjustReport.builder()
							.reportText(priceChanegReport.append(" to ").append(sale.getPrice()).toString()).build());
				});
				break;
			case MULTIPLY:
				salesDetails.get().stream().forEach(sale -> {
					StringBuilder priceChanegReport = new StringBuilder("MULTIPLY operation on ")
							.append(sale.getSalesName()).append(" price change from").append(sale.getPrice());
					sale.setPrice(sale.getPrice().multiply(salesAdjustment.getOperationAmount()));
					priceAdjustReportRepository.save(PriceAdjustReport.builder()
							.reportText(priceChanegReport.append(" to ").append(sale.getPrice()).toString()).build());
				});
				break;
			}
			 salesRepository.saveAll(salesDetails.get());
		}else{
			throw new SalesProcessorException("Product not found");
		}

	}

	@Override
	public boolean isSpecifiedMessageProcessed(long numberOfMessages) {
		long totalMessagesProcessed = salesRepository.count()+salesAdjustmentRepository.count();
		if(totalMessagesProcessed>numberOfMessages){
			log.info("Crossed 50 messages and no further messages can be processed");
			return true;
		}
		return false;
	}
}
