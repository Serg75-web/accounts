
package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void boundaryValuesForAccountReplenishment1() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void boundaryValuesForAccountReplenishment2() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void boundaryValuesForAccountReplenishment3() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(1);

        Assertions.assertEquals(2_001, account.getBalance());
    }

    @Test
    public void boundaryValuesForAccountReplenishment4() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(7_999);

        Assertions.assertEquals(2_000 + 7_999, account.getBalance());
    }

    @Test
    public void boundaryValuesForAccountReplenishment5() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test
    public void boundaryValuesForAccountReplenishment6() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_001);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void theMinBalanceIsGreaterThanTheMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    200,
                    10_000,
                    1_000,
                    5);
        });
    }

    @Test
    public void negativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    200,
                    -1_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void negativeMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    200,
                    1_000,
                    -10_000,
                    5);
        });
    }

    @Test
    public void purchaseOfGoods() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void marginalBalanceValuesWhenPurchasingAProduct1() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.pay(2_001);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void marginalBalanceValuesWhenPurchasingAProduct2() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.pay(2_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void marginalBalanceValuesWhenPurchasingAProduct3() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.pay(1_999);

        Assertions.assertEquals(1, account.getBalance());
    }

    @Test
    public void marginalValuesOfTheProductPriceWhenDigging1() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.pay(-1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void marginalValuesOfTheProductPriceWhenDigging2() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void marginalValuesOfTheProductPriceWhenDigging3() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        account.pay(1);

        Assertions.assertEquals(1_999, account.getBalance());
    }

    @Test
    public void theBalanceIsLessThanTheMinimumBalanceWhenBuyingAnItem() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_500,
                10_000,
                5
        );

        account.pay(1000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void theInterestRateIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    200,
                    1_000,
                    10_000,
                    -1);
        });

    }

    @Test
    public void theOperationOfCalculatingInterestOnTheAccountBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1000,
                10_000,
                5
        );
        Assertions.assertEquals(100, account.yearChange());
    }
}
