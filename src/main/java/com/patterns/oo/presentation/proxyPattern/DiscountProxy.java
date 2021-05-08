package com.patterns.oo.presentation.proxyPattern;

import com.patterns.oo.presentation.models.EmployeeType;

import java.math.BigDecimal;

public interface DiscountProxy {

    BigDecimal getEmployeeDiscount(final EmployeeType employeeType, final BigDecimal orderTotal);
}
