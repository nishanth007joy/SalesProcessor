package com.nish.salesprocessor.writer.impl;

import org.junit.Test;

import com.nish.salesprocessor.basetest.BaseTest;
import com.nish.salesprocessor.reporttype.ReportType;
import com.nish.salesprocessor.writer.ReportWriter;

public class ReportWriterImplTest extends BaseTest{
	private ReportWriter reportWriter = new ReportWriterImpl();
	@Test
	public void test() {
		String reportText  = "Orange,2,2.00";
		reportWriter.writeReport(reportText, ReportType.TEN_MESSAGE_REPORT);
	}

}
