package com.nish.salesprocessor.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nish.salesprocessor.model.PriceAdjustReport;
import com.nish.salesprocessor.model.SaleDetails;
import com.nish.salesprocessor.reporttype.ReportType;
import com.nish.salesprocessor.repository.PriceAdjustReportRepository;
import com.nish.salesprocessor.repository.SalesAdjustmentRepository;
import com.nish.salesprocessor.repository.SalesRepository;
import com.nish.salesprocessor.service.ReportService;
import com.nish.salesprocessor.writer.ReportWriter;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportWriter reportWriter;
	@Autowired
	private SalesRepository salesRepository;
	
	@Autowired
	private SalesAdjustmentRepository salesAdjustmentRepository;
	
	@Autowired
	private PriceAdjustReportRepository priceAdjustReportRepository;

	@Override
	public String generateReport() {
		Optional<List<SaleDetails>> saleDetails = salesRepository.findAllByOrderByIdAsc();
		Map<String, List<SaleDetails>> mappedSaleDetails = saleDetails.get().stream()
				.collect(Collectors.groupingBy(SaleDetails::getSalesName));
		Function<String, String> mappeListtoReportText = keyForMap -> {
			List<SaleDetails> groupedList = mappedSaleDetails.get(keyForMap);
			int sumOfQuantity = groupedList.stream().mapToInt(SaleDetails::getQuantity).sum();
			BigDecimal valueAggregate = groupedList.stream()
					.map(saleDetail -> saleDetail.getPrice().multiply(new BigDecimal(saleDetail.getQuantity())))
					.reduce(BigDecimal.ZERO.setScale(2), BigDecimal::add);
			String reportText = new StringBuilder(keyForMap).append(",").append(sumOfQuantity).append(",")
					.append(valueAggregate).toString();
			return reportText;
		};
		if (salesRepository.count()+ salesAdjustmentRepository.count() == 10) {
			if (saleDetails.isPresent()) {

				String reportText = mappedSaleDetails.keySet().stream().map(mappeListtoReportText)
						.collect(Collectors.joining("\n"));
				reportWriter.writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
			}
		} else if (salesRepository.count()+ salesAdjustmentRepository.count() == 20) {
			if (saleDetails.isPresent()) {
				String reportText = mappedSaleDetails.keySet().stream().map(mappeListtoReportText)
						.collect(Collectors.joining("\n"));
				reportWriter.writeReport(reportText, ReportType.TWENTY_MESSAGE_REPORT);
			}
		} else if (salesRepository.count()+ salesAdjustmentRepository.count() == 30) {
			if (saleDetails.isPresent()) {
				String reportText = mappedSaleDetails.keySet().stream().map(mappeListtoReportText)
						.collect(Collectors.joining("\n"));
				reportWriter.writeReport(reportText, ReportType.THIRTY_MESSAGE_REPORT);
			}
		} else if (salesRepository.count()+ salesAdjustmentRepository.count() == 40) {
			if (saleDetails.isPresent()) {
				String reportText = mappedSaleDetails.keySet().stream().map(mappeListtoReportText)
						.collect(Collectors.joining("\n"));
				reportWriter.writeReport(reportText, ReportType.FORTY_MESSAGE_REPORT);
			}
		} else if (salesRepository.count()+ salesAdjustmentRepository.count() == 50) {
			reportWriter.writeReport(priceAdjustReportRepository.findAll().stream()
					.map(PriceAdjustReport::getReportText).collect(Collectors.joining("\n")),
					ReportType.FINAL_ADJUSTMENT_REPORT);
		}
		return null;
	}

}
