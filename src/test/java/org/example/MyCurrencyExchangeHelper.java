package org.example;

public class MyCurrencyExchangeHelper implements CurrencyExchange {

    @Override
    public float getRate(String currency) {
        if (currency.equals("tenge")) {
            return 480;
        }
        throw new UnsupportedOperationException("other currencies are not implemented");
    }
}
