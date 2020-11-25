package com.zk.msscbeerorderservice.sm.actions;

import com.zk.brewery.model.events.AllocateOrderRequest;
import com.zk.msscbeerorderservice.config.JmsConfig;
import com.zk.msscbeerorderservice.domain.BeerOrder;
import com.zk.msscbeerorderservice.domain.BeerOrderEventEnum;
import com.zk.msscbeerorderservice.domain.BeerOrderStatusEnum;
import com.zk.msscbeerorderservice.repositories.BeerOrderRepository;
import com.zk.msscbeerorderservice.services.BeerOrderManagerImpl;
import com.zk.msscbeerorderservice.web.mappers.BeerOrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class AllocateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

    private final BeerOrderRepository beerOrderRepository;
    private final BeerOrderMapper beerOrderMapper;
    private final JmsTemplate jmsTemplate;

    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> context) {
        final String beerOrderId = (String) context.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
        BeerOrder beerOrder = beerOrderRepository.findOneById(UUID.fromString(beerOrderId));

        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_QUEUE, AllocateOrderRequest.builder()
                .beerOrderDto(beerOrderMapper.beerOrderToDto(beerOrder))
                .build());

        log.debug("Sent Allocation request for order id " + beerOrderId);
    }
}
