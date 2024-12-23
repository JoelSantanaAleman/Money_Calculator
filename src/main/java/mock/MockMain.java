package mock;

import control.ExchangeRatesCommand;
import control.interfaces.Command;
import control.interfaces.ExchangeRatesLoader;
import model.Currency;
import swing.interfaces.CurrencyDialog;
import swing.interfaces.MoneyDialog;
import swing.interfaces.MoneyDisplay;

import java.io.IOException;
import java.util.List;

public class MockMain {
    public static void main(String[] args) throws IOException {
        List<Currency> currencies = new MockCurrencyLoader().load();
        MoneyDialog moneyDialog = new MockMoneyDialog().define(currencies);
        CurrencyDialog currencyDialog = new MockCurrencyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        ExchangeRatesLoader exchangeRateLoader = new MockExchangeRateLoader();
        Command command = new ExchangeRatesCommand(moneyDisplay, moneyDialog, currencyDialog, exchangeRateLoader);
        command.execute();
    }
}

