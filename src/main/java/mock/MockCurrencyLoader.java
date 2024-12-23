package mock;

import control.interfaces.CoinsLoader;
import model.Currency;

import java.util.List;

public class MockCurrencyLoader implements CoinsLoader {
    @Override
    public List<Currency> load() {
        return List.of(
                new Currency("EUR", "Euro"),
                new Currency("USD", "Dolar"),
                new Currency("GBP", "Libra")
        );
    }
}