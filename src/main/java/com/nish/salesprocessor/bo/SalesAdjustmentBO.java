package com.nish.salesprocessor.bo;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.nish.salesprocessor.operationtype.Operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
/**
 * Sale adjustment BO to hold sale adjustments and annotated to validate input
 * @author n.mathew.joy
 *
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SalesAdjustmentBO {
	@NotNull(message = "Sales name cannot be null")
	private String salesName;
	@NotNull(message = "Operation cannot be null")
	private Operation operation;
	@NotNull(message = "Operation amount cannot be null")
	private BigDecimal operationAmount;
}
