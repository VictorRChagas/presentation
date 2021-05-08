package com.patterns.oo.presentation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Employee {

    private final String name;
    private final EmployeeType employeeType;

}
