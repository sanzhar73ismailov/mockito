package org.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateSalaryTestWithoutMockIT {

    @Test
    public void shouldUse20ProcentWhenExperienceMoreThan10Years() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        Emp emp12YearsExperience = Emp.builder()
                .name("A")
                .salaryUsd(100F)
                .experience(12)
                .build();
        CurrencyExchange currencyExchange = new MyCurrencyExchangeHelper();
        float salaryTenge = salaryCalculator.calculateSalaryFromDollars(emp12YearsExperience, currencyExchange);
        assertEquals(57600, salaryTenge, 0);
    }
}
