package com.nish.salesprocessor.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.nish.salesprocessor.bo.SaleDetailsBO;
import com.nish.salesprocessor.bo.SalesAdjustmentBO;
import com.nish.salesprocessor.model.SaleDetails;
import com.nish.salesprocessor.model.SalesAdjustment;

/**
 * Mapper class for mapping from BO to entity and from entity to BO
 * 
 * @author n.mathew.joy
 *
 */
@Mapper
public interface SalesDetailsMapper {
	public static final SalesDetailsMapper instance = Mappers.getMapper(SalesDetailsMapper.class);

	/**
	 * Mapping from BO to entity
	 * 
	 * @param saleDetailsBO
	 * @return
	 */
	@Mappings({ @Mapping(source = "price", target = "adjustedPrice"), @Mapping(source = "price", target = "price") })
	public SaleDetails salesDetailsBOToSalesDetailsEntity(SaleDetailsBO saleDetailsBO);

	/**
	 * 
	 * @param salesDetails
	 * @return
	 */
	@IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
	public List<SaleDetailsBO> salesDetailsEntityListToSalesDetailsBOList(List<SaleDetails> salesDetails);

	/**
	 * 
	 * @param salesDetails
	 * @return
	 */
	public SaleDetailsBO salesDetailsEntityToSalesDetailsBO(SaleDetails salesDetails);

	/**
	 * 
	 * @param adjustmentBO
	 * @return
	 */
	public SalesAdjustment salesAdjustmentBOToSalesAdjustmentEntity(SalesAdjustmentBO adjustmentBO);
}
