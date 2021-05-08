package com.patterns.oo.presentation;

import com.patterns.oo.presentation.models.*;
import com.patterns.oo.presentation.proxyPattern.DiscountProxy;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DiscountProxyTest {

    private final DiscountProxy discountProxy;

    public DiscountProxyTest(final DiscountProxy discountProxy) {
        this.discountProxy = discountProxy;
    }


    /**
     * The main idea is to use Spring to help us in the injection of the dependencies, but I could be done without
     * Spring as well, but you would need to instance it manually, all the possible implementations
     *
     * Event created for testing the abstraction using the dependency injection, otherwise, I could have built unit
     * tests, but as the goal here is for learning, I prefered to write it this way
     *
     */
    @EventListener
    public void testIfDiscountProxyWorksProperly(final ApplicationStartedEvent event) {
        final var order = getNewOrderBuilt();

        final var orderTotal = order.getTotal();

        final var employeeDiscount = this.discountProxy.getEmployeeDiscount(order.getEmployeeType(), orderTotal);
        final var totalAfterApplyingDiscount = orderTotal.subtract(employeeDiscount);

        System.out.printf("The total after applying the discount is %s: ", totalAfterApplyingDiscount);
    }

    private Order getNewOrderBuilt() {
        final var employee = Employee.builder()
                .name("João Victor")
                .employeeType(EmployeeType.ORDINARY)
                .build();

        final var item = Item.builder()
                .description("Computer")
                .build();

        final var itemOrder = ItemOrder.builder()
                .item(item)
                .quantity(2)
                .unityPrice(BigDecimal.valueOf(500))
                .build();

        return Order.builder()
                .employee(employee)
                .itemList(List.of(itemOrder))
                .build();
    }
}
