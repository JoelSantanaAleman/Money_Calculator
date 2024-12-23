import control.*;
import control.interfaces.CoinsLoader;
import control.interfaces.ExchangeRatesLoader;
import model.Currency;
import swing.interfaces.CurrencyDialog;
import swing.MainFrame;
import swing.interfaces.MoneyDialog;
import swing.interfaces.MoneyDisplay;

import java.io.InputStream;
import java.util.List;

public class MainGUI {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        ClassLoader classLoader = MainGUI.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("currencies.tsv");
        if (inputStream == null) {
            System.err.println("Error: No se pudo encontrar el archivo currencies.tsv.");
            System.exit(1);
        }
        CoinsLoader coinsLoader = new TsvFileCoinsLoader(inputStream);
        List<Currency> currencyList = coinsLoader.load();
        MoneyDialog moneyDialog = frame.getMoneyDialog().define(currencyList);
        CurrencyDialog currencyDialog = frame.getCurrencyDialog().define(currencyList);
        MoneyDisplay moneyDisplay = frame.getMoneyDisplay();
        ExchangeRatesLoader exchangeRatesLoader = new JsonExchangeRatesLoader();
        frame.add("change", new ExchangeRatesCommand(moneyDisplay, moneyDialog, currencyDialog, exchangeRatesLoader));
        frame.setVisible(true);
    }
}
