package com.nish.salesprocessor.service.impl;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.nish.salesprocessor.basetest.BaseTest;
import com.nish.salesprocessor.bo.SaleDetailsBO;
import com.nish.salesprocessor.bo.SalesAdjustmentBO;
import com.nish.salesprocessor.mapper.SalesDetailsMapper;
import com.nish.salesprocessor.model.SaleDetails;
import com.nish.salesprocessor.model.SalesAdjustment;
import com.nish.salesprocessor.operationtype.Operation;
import com.nish.salesprocessor.repository.PriceAdjustReportRepository;
import com.nish.salesprocessor.repository.SalesAdjustmentRepository;
import com.nish.salesprocessor.repository.SalesRepository;
import com.nish.salesprocessor.service.SalesService;

public class SalesServiceImplTest extends BaseTest {
	@InjectMocks
	private SalesService salesService = new SalesServiceImpl();
	@Mock
	private SalesRepository salesRepository;
	@Mock
	private PriceAdjustReportRepository priceAdjustReportRepository;
	@Mock
	private SalesAdjustmentRepository salesAdjustmentRepository;
	@Mock
	private SalesDetailsMapper salesDetailsMapper;

	@Test
	public void testSaveSalesDetailsValid() {
		SaleDetailsBO saleDetailsBO = SaleDetailsBO.builder().salesName("Orange").quantity(20)
				.price(BigDecimal.valueOf(20.20)).build();
		SaleDetails saleDetails = new SaleDetails();
		saleDetails.setSalesName("Orange");
		saleDetails.setQuantity(20);
		saleDetails.setPrice(BigDecimal.valueOf(20.20));
		when(salesDetailsMapper.salesDetailsBOToSalesDetailsEntity(saleDetailsBO)).thenReturn(saleDetails);
		when(salesRepository.save(saleDetails)).thenReturn(saleDetails);
		salesService.saveSalesDetails(saleDetailsBO);
		verify(salesRepository, times(1)).save(saleDetails);
	}

	@Test
	public void testSaveSalesAdjustmentValid() {
		SalesAdjustmentBO salesAdjustmentBO = SalesAdjustmentBO.builder().salesName("Orange")
				.operationAmount(BigDecimal.valueOf(20.20)).operation(Operation.ADD).build();
		SalesAdjustment salesAdjustment = new SalesAdjustment();
		salesAdjustment.setOperation(Operation.ADD);
		salesAdjustment.setSalesName("Orange");
		when(salesDetailsMapper.salesAdjustmentBOToSalesAdjustmentEntity(salesAdjustmentBO))
				.thenReturn(salesAdjustment);
		List<SaleDetails> saleList = new ArrayList<>();
		SaleDetails saleDetails = new SaleDetails();
		saleDetails.setSalesName("Orange");
		saleDetails.setQuantity(20);
		saleDetails.setPrice(BigDecimal.valueOf(20.20));
		saleList.add(saleDetails);
		Optional<List<SaleDetails>> saleOptional = Optional.of(saleList);
		when(salesRepository.findBySalesName(anyString())).thenReturn(saleOptional);
		salesAdjustment.setOperationAmount(BigDecimal.valueOf(20.20));
		salesService.saveSalesAdjustment(salesAdjustmentBO);
		saleDetails.setPrice(saleDetails.getPrice().add(salesAdjustment.getOperationAmount()));
		verify(salesRepository, times(1)).saveAll(saleList);
	}
	@Test
	public void testSaveSalesAdjustmentSubtractValid() {
		SalesAdjustmentBO salesAdjustmentBO = SalesAdjustmentBO.builder().salesName("Orange")
				.operationAmount(BigDecimal.valueOf(20.20)).operation(Operation.SUBTRACT).build();
		SalesAdjustment salesAdjustment = new SalesAdjustment();
		salesAdjustment.setOperation(Operation.SUBTRACT);
		salesAdjustment.setSalesName("Orange");
		when(salesDetailsMapper.salesAdjustmentBOToSalesAdjustmentEntity(salesAdjustmentBO))
				.thenReturn(salesAdjustment);
		List<SaleDetails> saleList = new ArrayList<>();
		SaleDetails saleDetails = new SaleDetails();
		saleDetails.setSalesName("Orange");
		saleDetails.setQuantity(20);
		saleDetails.setPrice(BigDecimal.valueOf(20.20));
		saleList.add(saleDetails);
		Optional<List<SaleDetails>> saleOptional = Optional.of(saleList);
		when(salesRepository.findBySalesName(anyString())).thenReturn(saleOptional);
		salesAdjustment.setOperationAmount(BigDecimal.valueOf(20.20));
		salesService.saveSalesAdjustment(salesAdjustmentBO);
		saleDetails.setPrice(saleDetails.getPrice().subtract(salesAdjustment.getOperationAmount()));
		verify(salesRepository, times(1)).saveAll(saleList);
	}
	@Test
	public void testSaveSalesAdjustmentMultiplyValid() {
		SalesAdjustmentBO salesAdjustmentBO = SalesAdjustmentBO.builder().salesName("Orange")
				.operationAmount(BigDecimal.valueOf(20.20)).operation(Operation.MULTIPLY).build();
		SalesAdjustment salesAdjustment = new SalesAdjustment();
		salesAdjustment.setOperation(Operation.MULTIPLY);
		salesAdjustment.setSalesName("Orange");
		when(salesDetailsMapper.salesAdjustmentBOToSalesAdjustmentEntity(salesAdjustmentBO))
				.thenReturn(salesAdjustment);
		List<SaleDetails> saleList = new ArrayList<>();
		SaleDetails saleDetails = new SaleDetails();
		saleDetails.setSalesName("Orange");
		saleDetails.setQuantity(20);
		saleDetails.setPrice(BigDecimal.valueOf(20.20));
		saleList.add(saleDetails);
		Optional<List<SaleDetails>> saleOptional = Optional.of(saleList);
		when(salesRepository.findBySalesName(anyString())).thenReturn(saleOptional);
		salesAdjustment.setOperationAmount(BigDecimal.valueOf(20.20));
		salesService.saveSalesAdjustment(salesAdjustmentBO);
		saleDetails.setPrice(saleDetails.getPrice().multiply(salesAdjustment.getOperationAmount()));
		verify(salesRepository, times(1)).saveAll(saleList);
	}
}
