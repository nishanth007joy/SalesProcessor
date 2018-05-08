package com.nish.salesprocessor.service.impl;

import static org.mockito.Mockito.doNothing;
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
import com.nish.salesprocessor.model.SaleDetails;
import com.nish.salesprocessor.reporttype.ReportType;
import com.nish.salesprocessor.repository.PriceAdjustReportRepository;
import com.nish.salesprocessor.repository.SalesAdjustmentRepository;
import com.nish.salesprocessor.repository.SalesRepository;
import com.nish.salesprocessor.service.ReportService;
import com.nish.salesprocessor.writer.ReportWriter;

public class ReportServiceImplTest extends BaseTest{
	@InjectMocks
	private ReportService reportService = new ReportServiceImpl();
	@Mock
	private ReportWriter reportWriter;
	@Mock
	private SalesRepository salesRepository;
	@Mock
	private SalesAdjustmentRepository salesAdjustmentRepository;
	@Mock
	private PriceAdjustReportRepository priceAdjustReportRepository;
	@Test
	public void testReport10Message() {
		String reportText = "Grapes,1,16.00";
		SaleDetails saleDetails = new SaleDetails();
		saleDetails.setSalesName("Grapes");
		saleDetails.setQuantity(1);
		saleDetails.setPrice(BigDecimal.valueOf(16.00));
		List<SaleDetails> saleDetailsList = new ArrayList<>();
		saleDetailsList.add(saleDetails);
		doNothing().when(reportWriter).writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
		when(salesRepository.count()).thenReturn(Long.valueOf(10));
		when(salesAdjustmentRepository.count()).thenReturn(Long.valueOf(0));
		when(salesRepository.findAllByOrderByIdAsc()).thenReturn(Optional.of(saleDetailsList));
		reportService.generateReport();
		verify(reportWriter, times(1)).writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
	}
	public void testReport20Message() {
		String reportText = "Grapes,1,16.00";
		SaleDetails saleDetails = new SaleDetails();
		saleDetails.setSalesName("Grapes");
		saleDetails.setQuantity(1);
		saleDetails.setPrice(BigDecimal.valueOf(16.00));
		List<SaleDetails> saleDetailsList = new ArrayList<>();
		saleDetailsList.add(saleDetails);
		doNothing().when(reportWriter).writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
		when(salesRepository.count()).thenReturn(Long.valueOf(20));
		when(salesAdjustmentRepository.count()).thenReturn(Long.valueOf(0));
		when(salesRepository.findAllByOrderByIdAsc()).thenReturn(Optional.of(saleDetailsList));
		reportService.generateReport();
		verify(reportWriter, times(1)).writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
	}
	public void testReport30Message() {
		String reportText = "Grapes,1,16.00";
		SaleDetails saleDetails = new SaleDetails();
		saleDetails.setSalesName("Grapes");
		saleDetails.setQuantity(1);
		saleDetails.setPrice(BigDecimal.valueOf(16.00));
		List<SaleDetails> saleDetailsList = new ArrayList<>();
		saleDetailsList.add(saleDetails);
		doNothing().when(reportWriter).writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
		when(salesRepository.count()).thenReturn(Long.valueOf(30));
		when(salesAdjustmentRepository.count()).thenReturn(Long.valueOf(0));
		when(salesRepository.findAllByOrderByIdAsc()).thenReturn(Optional.of(saleDetailsList));
		reportService.generateReport();
		verify(reportWriter, times(1)).writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
	}
	public void testReport140Message() {
		String reportText = "Grapes,1,16.00";
		SaleDetails saleDetails = new SaleDetails();
		saleDetails.setSalesName("Grapes");
		saleDetails.setQuantity(1);
		saleDetails.setPrice(BigDecimal.valueOf(16.00));
		List<SaleDetails> saleDetailsList = new ArrayList<>();
		saleDetailsList.add(saleDetails);
		doNothing().when(reportWriter).writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
		when(salesRepository.count()).thenReturn(Long.valueOf(40));
		when(salesAdjustmentRepository.count()).thenReturn(Long.valueOf(0));
		when(salesRepository.findAllByOrderByIdAsc()).thenReturn(Optional.of(saleDetailsList));
		reportService.generateReport();
		verify(reportWriter, times(1)).writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
	}

}
