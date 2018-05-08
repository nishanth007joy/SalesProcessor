package com.nish.salesprocessor.steprunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nish.salesprocessor.bo.SaleDetailsBO;
import com.nish.salesprocessor.bo.SalesAdjustmentBO;
import com.nish.salesprocessor.operationtype.Operation;
import com.nish.salesprocessor.repository.PriceAdjustReportRepository;
import com.nish.salesprocessor.repository.SalesAdjustmentRepository;
import com.nish.salesprocessor.repository.SalesRepository;
import com.nish.salesprocessor.response.Message;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefenition extends CucumberSpringIntegration {
	@Autowired
	private SalesRepository salesRepository;
	@Autowired
	private SalesAdjustmentRepository salesAdjustmentRepository;
	@Autowired
	private PriceAdjustReportRepository priceAdjustReportRepository;

	@Given("^Sale api running on \"([^\"]*)\" url$")
	public void sale_api_running_on_url(String arg1) throws Throwable {

	}

	@When("^sale is processed with sale name as \"([^\"]*)\" and price as \"([^\"]*)\" and quantity as \"([^\"]*)\"$")
	public void sale_is_processed_with_sale_name_as_and_price_as_and_quantity_as(String saleName, String price,
			String quantity) throws Throwable {
		SaleDetailsBO detailsBO = SaleDetailsBO.builder().salesName(saleName).price(new BigDecimal(price))
				.quantity(Integer.parseInt(quantity)).build();
		ResponseEntity<Message> response = template.postForEntity("http://localhost:8080/salesprocessor/sales/",
				detailsBO, Message.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

	@Then("^show save trade details$")
	public void show_save_trade_details() throws Throwable {

	}

	@When("^sale is processed with sale below input$")
	public void sale_is_processed_with_sale_below_input(List<List<String>> inputData) throws Throwable {
		// List<SaleDetailsBO> saleBOs = inputData.stream().map(input ->
		// SaleDetailsBO.builder().salesName(input.get(0))
		// .quantity(Integer.parseInt(input.get(2))).price(new
		// BigDecimal(input.get(1))).build()).collect(Collectors.toList());
		Consumer<List<String>> saleTrigger = saleLine -> {
			ResponseEntity<Message> response = null;
			if (saleLine.get(3).equals("ADD") || saleLine.get(3).equals("SUBTRACT")
					|| saleLine.get(3).equals("MULTIPLY")) {
				response = template.postForEntity("http://localhost:8080/salesprocessor/sales/operation",
						SalesAdjustmentBO.builder().salesName(saleLine.get(0))
								.operation(Operation.valueOf(saleLine.get(3)))
								.operationAmount(new BigDecimal(saleLine.get(1))).build(),
						Message.class);
			} else {
				response = template.postForEntity("http://localhost:8080/salesprocessor/sales/",
						SaleDetailsBO.builder().salesName(saleLine.get(0)).quantity(Integer.parseInt(saleLine.get(2)))
								.price(new BigDecimal(saleLine.get(1))).build(),
						Message.class);
			}
			assertEquals(Integer.parseInt(saleLine.get(4)),response.getStatusCode().value());
		};
		inputData.stream().forEach(saleTrigger);
	}

	@Then("^check report below reports are generated$")
	public void check_report_below_reports_are_generated(List<String> input) throws Throwable {

	}

	@Then("^check \"([^\"]*)\" report is generated$")
	public void check_report_is_generated(String arg1, List<String> arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("TEN_MESSAGE_REPORT")) {
			StringBuilder contentBuilder = new StringBuilder();
			Stream<String> stream = null;
			try {
				Path TEN_MESSAGE_REPORT = Paths.get("src/main/resources/SalesReport/TEN_MESSAGE_REPORT.csv");
				stream = Files.lines(TEN_MESSAGE_REPORT, StandardCharsets.UTF_8);
				stream.forEach(s -> contentBuilder.append(s).append(" "));
				contentBuilder.toString();
				arg2.stream().collect(Collectors.joining(" "));
			} catch (IOException ioException) {

			} finally {
				if (stream != null)
					stream.close();
			}
			assertEquals(arg2.stream().collect(Collectors.joining(" ")).trim(), contentBuilder.toString().trim());

		} else if (arg1.equalsIgnoreCase("TWENTY_MESSAGE_REPORT")) {
			StringBuilder contentBuilder = new StringBuilder();
			Stream<String> stream = null;
			try {
				Path TWENTY_MESSAGE_REPORT = Paths.get("src/main/resources/SalesReport/TWENTY_MESSAGE_REPORT.csv");
				stream = Files.lines(TWENTY_MESSAGE_REPORT, StandardCharsets.UTF_8);
				stream.forEach(s -> contentBuilder.append(s).append(" "));
				contentBuilder.toString();
				arg2.stream().collect(Collectors.joining(" "));
			} catch (IOException ioException) {

			} finally {
				if (stream != null)
					stream.close();
			}
			assertEquals(arg2.stream().collect(Collectors.joining(" ")).trim(), contentBuilder.toString().trim());
		} else if (arg1.equalsIgnoreCase("THIRTY_MESSAGE_REPORT")) {
			StringBuilder contentBuilder = new StringBuilder();
			Stream<String> stream = null;
			try {
				Path THIRTY_MESSAGE_REPORT = Paths.get("src/main/resources/SalesReport/THIRTY_MESSAGE_REPORT.csv");
				stream = Files.lines(THIRTY_MESSAGE_REPORT, StandardCharsets.UTF_8);
				stream.forEach(s -> contentBuilder.append(s).append(" "));
				contentBuilder.toString();
				arg2.stream().collect(Collectors.joining(" "));
			} catch (IOException ioException) {

			} finally {
				if (stream != null)
					stream.close();
			}
			assertEquals(arg2.stream().collect(Collectors.joining(" ")).trim(), contentBuilder.toString().trim());
		} else if (arg1.equalsIgnoreCase("FORTY_MESSAGE_REPORT")) {
			StringBuilder contentBuilder = new StringBuilder();
			Stream<String> stream = null;
			try {
				Path FORTY_MESSAGE_REPORT = Paths.get("src/main/resources/SalesReport/FORTY_MESSAGE_REPORT.csv");
				stream = Files.lines(FORTY_MESSAGE_REPORT, StandardCharsets.UTF_8);
				stream.forEach(s -> contentBuilder.append(s).append(" "));
				contentBuilder.toString();
				arg2.stream().collect(Collectors.joining(" "));
			} catch (IOException ioException) {

			} finally {
				if (stream != null)
					stream.close();
			}
			assertEquals(arg2.stream().collect(Collectors.joining(" ")).trim(), contentBuilder.toString().trim());
		}
	}

	@Given("^Report folder and data in DB cleansed$")
	@Transactional
	public void report_folder_and_data_in_DB_cleansed() throws Throwable {
		salesRepository.deleteAll();
		salesAdjustmentRepository.deleteAll();
		priceAdjustReportRepository.deleteAll();
		Path TEN_MESSAGE_REPORT = Paths.get("src/main/resources/SalesReport/input/TEN_MESSAGE_REPORT.csv");
		Path TWENTY_MESSAGE_REPORT = Paths.get("src/main/resources/SalesReport/input/TWENTY_MESSAGE_REPORT.csv");
		Path THIRTY_MESSAGE_REPORT = Paths.get("src/main/resources/SalesReport/input/THIRTY_MESSAGE_REPORT.csv");
		Path FORTY_MESSAGE_REPORT = Paths.get("src/main/resources/SalesReport/input/FORTY_MESSAGE_REPORT.csv");
		Path FINAL_ADJUSTMENT_REPORT = Paths.get("src/main/resources/SalesReport/input/FINAL_ADJUSTMENT_REPORT.csv");
		if (Files.exists(TEN_MESSAGE_REPORT))
			Files.delete(TEN_MESSAGE_REPORT);
		if (Files.exists(TWENTY_MESSAGE_REPORT))
			Files.delete(TWENTY_MESSAGE_REPORT);
		if (Files.exists(THIRTY_MESSAGE_REPORT))
			Files.delete(THIRTY_MESSAGE_REPORT);
		if (Files.exists(FORTY_MESSAGE_REPORT))
			Files.delete(FORTY_MESSAGE_REPORT);
		if (Files.exists(FINAL_ADJUSTMENT_REPORT))
			Files.delete(FINAL_ADJUSTMENT_REPORT);

	}

}
