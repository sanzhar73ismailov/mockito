package org.example;

public class SalaryCalculator {
    public float calculateSalaryFromDollars(Emp person, CurrencyExchange currencyExchange) {
        float salaryUsd = person.getSalaryUsd();
        float rate = currencyExchange.getRate("tenge");
        float salaryTenge = salaryUsd * rate;
        if (person.getExperience() >= 10)
            salaryTenge = (float) (salaryTenge + (salaryTenge * 0.2));
        return salaryTenge;
    }
}
