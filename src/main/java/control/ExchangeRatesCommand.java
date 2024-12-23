package control;

import control.interfaces.Command;
import control.interfaces.ExchangeRatesLoader;
import swing.interfaces.CurrencyDialog;
import swing.interfaces.MoneyDialog;
import swing.interfaces.MoneyDisplay;
import model.Currency;
import model.ExchangeRates;
import model.Money;

import java.io.IOException;

public class ExchangeRatesCommand implements Command {
    private final MoneyDisplay moneyDisplay;
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRatesLoader exchangeRatesLoader;

    public ExchangeRatesCommand(MoneyDisplay moneyDisplay, MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRatesLoader exchangeRatesLoader) {
        this.moneyDisplay = moneyDisplay;
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRatesLoader = exchangeRatesLoader;
    }

    @Override
    public void execute() throws IOException {
        Money money = moneyDialog.get();
        Currency target = currencyDialog.get();
        exchangeRatesLoader.setUrl(money.getCurrency(), target);
        ExchangeRates exchangeRates = exchangeRatesLoader.load(money.getCurrency(), target);
        Money result = new Money((double) (money.getAmount()*exchangeRates.getRate()), target);
        moneyDisplay.show(result);

    }
}
