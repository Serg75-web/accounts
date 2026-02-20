package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }


    @Test
    public void negativeRate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, 5_000, -10);
        });

        String expectedMessage = "Накопительная ставка не может быть отрицательной, а у вас: -10";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void negativeInitialBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(-1_000, 5_000, 15);
        });

        String expectedMessage = "Начальный баланс не может быть отрицательным, а у вас: -1_000";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void negativeCreditLimit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(0, -5_000, 15);
        });

        String expectedMessage = "Кредитный лимит не может быть отрицательным, а у вас: -5_000";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void payCard() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        boolean result = account.pay(6_000);

        Assertions.assertEquals(false, account.getBalance());
    }
}