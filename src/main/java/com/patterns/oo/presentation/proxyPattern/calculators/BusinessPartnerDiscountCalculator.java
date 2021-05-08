package com.patterns.oo.presentation.proxyPattern.calculators;

import com.patterns.oo.presentation.models.EmployeeType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class BusinessPartnerDiscountCalculator implements DiscountCalculator {

    @Override
    public BigDecimal getEmployeeDiscount(final BigDecimal orderTotal) {
        return orderTotal
                .multiply(BigDecimal.valueOf(15))
                .divide(BigDecimal.valueOf(100), RoundingMode.DOWN);
    }

    @Override
    public EmployeeType getType() {
        return EmployeeType.BUSINESS_PARTNER;
    }
}
