package com.zk.msscbeerorderservice.web.mappers;

import com.zk.msscbeerorderservice.domain.BeerOrder;
import com.zk.msscbeerorderservice.web.model.BeerOrderDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}