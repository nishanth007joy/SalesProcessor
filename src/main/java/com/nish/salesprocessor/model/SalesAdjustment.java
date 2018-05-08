package com.nish.salesprocessor.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nish.salesprocessor.operationtype.Operation;

import lombok.Getter;
import lombok.Setter;
/**
 * Sale adjustments entity to save sale adjustments
 * @author n.mathew.joy
 *
 */
@Entity
@Table(name = "SALES_ADJUSTMENTS")
public class SalesAdjustment {
	@Id
	@GeneratedValue
	@Getter
	private Long id;
	@Getter
	@Setter
	private String salesName;
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private Operation operation;
	@Getter
	@Setter
	private BigDecimal operationAmount;
}
