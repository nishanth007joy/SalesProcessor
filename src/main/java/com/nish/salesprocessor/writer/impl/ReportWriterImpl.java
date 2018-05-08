package com.nish.salesprocessor.writer.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nish.salesprocessor.exception.SalesProcessorException;
import com.nish.salesprocessor.reporttype.ReportType;
import com.nish.salesprocessor.writer.ReportWriter;

@Component
public class ReportWriterImpl implements ReportWriter {
	private static final Logger log = LoggerFactory.getLogger(ReportWriterImpl.class);

	@Override
	public void writeReport(String reportText, ReportType reportType) {
		log.info("Report : "+ reportType.name());
		log.info(reportText);
		Path path = Paths.get(new StringBuilder(new StringBuilder("src/main/resources/SalesReport/")
				.append(reportType.name()).append(".csv").toString()).toString());
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(reportText);
			writer.flush();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new SalesProcessorException("Error in writing report", e);
		}

	}

}
