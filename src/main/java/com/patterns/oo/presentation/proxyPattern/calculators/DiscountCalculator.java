package com.patterns.oo.presentation.proxyPattern.calculators;

import com.patterns.oo.presentation.models.EmployeeType;

import java.math.BigDecimal;

public interface DiscountCalculator {

    BigDecimal getEmployeeDiscount(final BigDecimal orderTotal);

    EmployeeType getType();

}
