package com.patterns.oo.presentation.proxyPattern;

import com.patterns.oo.presentation.models.EmployeeType;
import com.patterns.oo.presentation.proxyPattern.calculators.DiscountCalculator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DiscountProxyImpl implements DiscountProxy {

    private final Map<EmployeeType, DiscountCalculator> discountCalculatorMap;

    public static final String EXCEPTION_MESSAGE_TEMPLATE = "%s has no any calculation implementation for respective type";

    public DiscountProxyImpl(final List<DiscountCalculator> discountCalculatorMap) {
        this.discountCalculatorMap = discountCalculatorMap.stream()
                .collect(Collectors.toMap(DiscountCalculator::getType, o -> o));
    }

    @Override
    public BigDecimal getEmployeeDiscount(final EmployeeType employeeType, final BigDecimal orderTotal) {
        final var discountCalculator = discountCalculatorMap.get(employeeType);
        final var isDiscountCalculatorPresent = Optional.ofNullable(discountCalculator)
                .isPresent();

        if (!isDiscountCalculatorPresent) {
            throw new RuntimeException(String.format(EXCEPTION_MESSAGE_TEMPLATE, employeeType));
        }

        return discountCalculator.getEmployeeDiscount(orderTotal);
    }
}
