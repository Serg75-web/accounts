package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,  // пополнение карты на положительную сумму
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }


    @Test
    public void negativeRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, 5_000, -10);
        });  // попытка создания кредитного счета с отрицательной ставкой кредитования

        String expectedMessage = "Накопительная ставка не может быть отрицательной, а у вас: -10";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void nullRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, 5_000, 0);
        });  // попытка создания кредитного счета с нулевой ставкой кредитования

        String expectedMessage = "Накопительная ставка не может быть отрицательной, а у вас: 0";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void negativeInitialBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1_000, 5_000, 15);
        }); // попытка создания кредитного счета с отрицательным начальным балансом

        String expectedMessage = "Начальный баланс не может быть отрицательным, а у вас: -1000";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void negativeCreditLimit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, -5_000, 15);
        }); // попытка создания кредитного счета с отрицательным кредитным лимитом

        String expectedMessage = "Кредитный лимит не может быть отрицательным, а у вас: -5000";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void payNegativeCard() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean result = account.pay(-6_000);  // попытка оплаты с карты отрицательной суммы

        Assertions.assertFalse(result);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void payNullCard() {
        CreditAccount account = new CreditAccount(
                100,
                5_000,
                15
        );

        boolean result = account.pay(0); // попытка оплаты с карты нулевой суммы

        Assertions.assertFalse(result);
        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    public void payMinusCard() {
        CreditAccount account = new CreditAccount(
                1000,
                500,
                10
        );

        boolean result = account.pay(2000); // попытка оплаты с карты суммы, при которой баланс становится меньше, чем лимит

        Assertions.assertEquals(false, account.getBalance());
    }

    @Test
    public void addCard() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        boolean result = account.add(6_000); // оплата, при которой баланс должен увеличиться на указанную сумму

        Assertions.assertEquals(7_000, account.getBalance());
    }

    @Test
    public void addNegativeCard() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        boolean result = account.add(-6_000); // попытка пополнения карты отрицательной суммой

        Assertions.assertFalse(result);
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void addNullCard() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        boolean result = account.add(0); // попытка пополнения карты нулевой суммой

        Assertions.assertFalse(result);
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void negativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                500,
                15
        );

        Assertions.assertEquals(-30, account.yearChange()); // расчет процентов на отрицательный баланс
    }

    @Test
    public void positiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                500,
                15
        );

        Assertions.assertEquals(0, account.yearChange()); // расчет процентов на положительный баланс
    }

    @Test
    public void nullBalance() {
        CreditAccount account = new CreditAccount(
                0,
                500,
                15
        );

        Assertions.assertEquals(0, account.yearChange()); // расчет процентов на нулевой баланс
    }
}