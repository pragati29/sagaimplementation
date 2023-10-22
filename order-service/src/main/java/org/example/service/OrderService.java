package org.example.service;

import org.example.dto.OrderRequestDto;
import org.example.entity.PurchaseOrder;
import org.example.event.OrderStatus;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderStatusPublisher orderStatusPublisher;
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) {
        PurchaseOrder order = orderRepository.save(convertDtoToEntity(orderRequestDto));
        orderRequestDto.setOrderId(order.getId());
        //Produce kafka event with status order created
        orderStatusPublisher.publishOrderEvent(orderRequestDto,OrderStatus.Created);
        return order;
    }

    public List<PurchaseOrder> getAllOrders(){

        return orderRepository.findAll();
    }

    private PurchaseOrder convertDtoToEntity(OrderRequestDto orderRequestDto){
        PurchaseOrder purchaseOrder =new PurchaseOrder();
        purchaseOrder.setProductId(orderRequestDto.getProductId());
        purchaseOrder.setOrderStatus(OrderStatus.Created);
        purchaseOrder.setUserId(orderRequestDto.getUserId());
       purchaseOrder.setPrice(orderRequestDto.getAmount());
       return purchaseOrder;
    }
}
