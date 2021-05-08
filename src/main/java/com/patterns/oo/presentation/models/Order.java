package com.patterns.oo.presentation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Getter
@Builder
@AllArgsConstructor
public class Order {

    private final Employee employee;
    private final List<ItemOrder> itemList;
    private final BigDecimal totalDiscount;

    @NonNull
    public BigDecimal getTotal() {
        return this.itemList.stream()
                .map(itemOrder -> itemOrder.getUnityPrice().multiply(BigDecimal.valueOf(itemOrder.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public EmployeeType getEmployeeType() {
        return Optional.ofNullable(this.employee)
                .map(Employee::getEmployeeType)
                .orElse(null);
    }
}
