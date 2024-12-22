package model;

import java.util.Objects;

public class Money {
    private final double number;
    private final Currency currency;

    public Money(double amount, Currency currency) {
        this.number = amount;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + number +
                ", currency=" + currency +
                '}';
    }

    public double getAmount() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(number, money.number) == 0 && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, currency);
    }

}
