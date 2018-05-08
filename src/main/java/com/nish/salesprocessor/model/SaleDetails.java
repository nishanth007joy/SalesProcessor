package com.nish.salesprocessor.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * Sale details entity to save sale instructions
 * @author n.mathew.joy
 *
 */
@Entity
@Table(name = "SALES_DETAILS")
@ToString
public class SaleDetails {
	@Id
	@GeneratedValue
	@Getter
	private Long id;
	@Getter
	@Setter
	private String salesName;
	@Getter
	@Setter
	private BigDecimal price;
	@Getter
	@Setter
	private BigDecimal adjustedPrice;
	@Getter
	@Setter
	private int quantity;

}
