package mock;

import model.Money;
import swing.interfaces.MoneyDisplay;

public class MockMoneyDisplay implements MoneyDisplay {
    @Override
    public void show(Money money) {
        System.out.println(money);
    }
}

