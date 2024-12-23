package mock;

import control.interfaces.ExchangeRatesLoader;
import model.Currency;
import model.ExchangeRates;

import java.io.IOException;
import java.time.LocalDate;

public class MockExchangeRateLoader implements ExchangeRatesLoader {
    @Override
    public void setUrl(Currency currency, Currency target) {

    }

    @Override
    public ExchangeRates load(Currency from, Currency to) throws IOException {
        return null;
    }
}