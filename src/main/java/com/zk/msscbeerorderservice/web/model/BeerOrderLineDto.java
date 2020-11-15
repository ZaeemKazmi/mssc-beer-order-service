package com.zk.msscbeerorderservice.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BeerOrderLineDto extends BaseItem {

    @Builder
    public BeerOrderLineDto(UUID id, Integer version, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate,
                            UUID beerId, String upc, String beerName, String beerStyle, BigDecimal price,
                            Integer orderQuantity) {
        super(id, version, createdDate, lastModifiedDate);
        this.beerId = beerId;
        this.upc = upc;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.price = price;
        this.orderQuantity = orderQuantity;
    }

    private UUID beerId;
    private String upc;
    private String beerName;
    private String beerStyle;
    private BigDecimal price;
    private Integer orderQuantity = 0;
}
