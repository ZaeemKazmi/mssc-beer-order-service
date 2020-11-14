package com.zk.msscbeerorderservice.web.mappers;

import com.zk.msscbeerorderservice.domain.BeerOrderLine;
import com.zk.msscbeerorderservice.web.model.BeerOrderLineDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}