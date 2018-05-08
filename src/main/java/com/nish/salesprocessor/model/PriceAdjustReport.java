package com.nish.salesprocessor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * Price adjustment entity to save adjustments happpened to sale
 * @author n.mathew.joy
 *
 */
@Entity
@Table(name = "PRICE_ADJUST_REPORT")
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PriceAdjustReport {
	@Id
	@GeneratedValue
	@Getter
	private Long id;
	@Getter
	@Setter
	private String reportText;
}
