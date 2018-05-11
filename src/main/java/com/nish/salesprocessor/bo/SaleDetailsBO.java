package com.nish.salesprocessor.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
/**
 * Sale Bo holds details of sale and this class have annotation to validate inputs
 * @author n.mathew.joy
 *
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SaleDetailsBO implements Serializable {
	private static final long serialVersionUID = -1L;
	@NotEmpty(message = "Sales name cannot be empty")
	private String salesName;
	@NotNull(message = "Price cannot be empty")
	@DecimalMax(value = "999.99", message = "Maximum value accepted is 999.99")
	private BigDecimal price;
	private BigDecimal adjustedPrice;
	@NotNull(message = "Sales quantity cannot be empty")
	private int quantity;
}
