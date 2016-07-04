package savings.model;

import static java.math.RoundingMode.HALF_EVEN;

import org.joda.money.Money;

import common.math.Percentage;
import common.model.Entity;

public class Merchant extends Entity {

    private String number;

    private String name;

    private Percentage payback;

    public Merchant(String number, String name) {
        this(number, name, Percentage.zero());
    }

    public Merchant(String number, String name, Percentage payback) {
        this.number = number;
        this.name = name;
        this.payback = payback;
    }

    public void setPayback(Percentage payback) {
        this.payback = payback;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Percentage getPayback() {
        return payback;
    }

    public Money calculatePaybackFor(Account account, Purchase purchase) {
        return purchase.getAmount().multipliedBy(payback.asBigDecimal(), HALF_EVEN);
    }

    @Override
    public String toString() {
        return "Merchant number = '" + number + "', name = '" + name + "', payback = " + payback;
    }
}
