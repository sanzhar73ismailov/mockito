package org.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class CalculateSalaryTestWithMockIT {

    @Test
    public void shouldUse20ProcentWhenExperienceMoreThan10Years() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        Emp emp12YearsExperience = Emp.builder()
                .name("A")
                .salaryUsd(100F)
                .experience(12)
                .build();

        CurrencyExchange currencyExchange = mock(CurrencyExchange.class);
        when(currencyExchange.getRate("tenge")).thenReturn(480F);

        float salaryTenge = salaryCalculator.calculateSalaryFromDollars(emp12YearsExperience, currencyExchange);
        assertEquals(57600, salaryTenge, 0.02);

        Mockito.verify(currencyExchange).getRate(any());
        Mockito.verify(currencyExchange, Mockito.times(1)).getRate(any());
        Mockito.verify(currencyExchange, Mockito.times(1)).getRate("tenge");
        Mockito.verify(currencyExchange, Mockito.times(0)).getRate("ruble");
        Mockito.verify(currencyExchange, Mockito.never()).getRate("ruble");
        Mockito.verify(currencyExchange, Mockito.atLeast(1)).getRate("tenge");
    }

    @Test
    public void shouldUse20ProcentWhenExperienceLessThan10Years() {
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        Emp emp8YearsExperience = Emp.builder()
                .name("A")
                .salaryUsd(100F)
                .experience(8)
                .build();

        CurrencyExchange currencyExchange = mock(CurrencyExchange.class);
        when(currencyExchange.getRate("tenge")).thenReturn(480F);

        float salaryTenge = salaryCalculator.calculateSalaryFromDollars(emp8YearsExperience, currencyExchange);
        assertEquals(48000, salaryTenge, 0);
    }

}
