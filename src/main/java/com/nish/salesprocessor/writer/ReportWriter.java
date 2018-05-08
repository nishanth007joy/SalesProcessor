package com.nish.salesprocessor.writer;

import com.nish.salesprocessor.reporttype.ReportType;

/**
 * Report writer
 * 
 * @author n.mathew.joy
 *
 */
public interface ReportWriter {
	/**
	 * Method to write sale report to report file
	 * 
	 * @param reportText
	 * @param reportType
	 */
	public void writeReport(String reportText, ReportType reportType);
}
