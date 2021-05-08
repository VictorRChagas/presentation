package com.patterns.oo.presentation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class ItemOrder {

    private final Item item;
    private final Integer quantity;
    private final BigDecimal unityPrice;

}
