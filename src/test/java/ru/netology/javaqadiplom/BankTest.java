package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    @Test
    public void transferFromTo() {
        Bank account = new Bank();

          Account accountFrom = new Account(1_000); // Счет на 1_000 рублей
          Account accountTo = new Account(2_000); // Счет на 2_000 рублей

          int initialBalanceFrom = accountFrom.getBalance(); // сохраняем начальные балансы
          int initialBalanceTo = accountTo.getBalance();

          boolean result = account.transfer(accountFrom, accountTo, 150);

          Assertions.assertTrue(result);
          Assertions.assertEquals(2150, accountTo.getBalance());
        }

    @Test
    public void transferFromTo1() {
        Bank account = new Bank();

        Account accountFrom = new Account(1_000); // Счет на 1_000 рублей
        Account accountTo = new Account(2_000); // Счет на 2_000 рублей

        int initialBalanceFrom = accountFrom.getBalance(); // сохраняем начальные балансы
        int initialBalanceTo = accountTo.getBalance();

        boolean result = account.transfer(accountFrom, accountTo, 1500);

        Assertions.assertFalse(result);
        Assertions.assertEquals(2_000, accountTo.getBalance());
    }

    @Test
    public void transferFromTo2() {
        Bank account = new Bank();

        Account accountFrom = new Account(1_000); // Счет на 1_000 рублей
        Account accountTo = new Account(2_000); // Счет на 2_000 рублей

        int initialBalanceFrom = accountFrom.getBalance(); // сохраняем начальные балансы
        int initialBalanceTo = accountTo.getBalance();

        boolean result = account.transfer(accountFrom, accountTo, 0);

        Assertions.assertFalse(result);
        Assertions.assertEquals(2_000, accountTo.getBalance());
    }

    @Test
    public void transferFromTo3() {
        Bank account = new Bank();

        Account accountFrom = new Account(1_000); // Счет на 1_000 рублей
        Account accountTo = new Account(2_000); // Счет на 2_000 рублей

        int initialBalanceFrom = accountFrom.getBalance(); // сохраняем начальные балансы
        int initialBalanceTo = accountTo.getBalance();

        boolean result = account.transfer(accountFrom, accountTo, -100);

        Assertions.assertFalse(result);
        Assertions.assertEquals(2_000, accountTo.getBalance());
    }

    @Test
    public void transferFromTo4() {
        Bank account = new Bank();

        Account accountFrom = new Account(0); // Счет с нулевым балансом
        Account accountTo = new Account(2_000); // Счет на 2_000 рублей

        int initialBalanceFrom = accountFrom.getBalance(); // сохраняем начальные балансы
        int initialBalanceTo = accountTo.getBalance();

        boolean result = account.transfer(accountFrom, accountTo, 100);

        Assertions.assertFalse(result);
        Assertions.assertEquals(2_000, accountTo.getBalance());
    }

    @Test
    public void transferFromTo5() {
        Bank account = new Bank();

        Account accountFrom = new Account(1_000); // Счет на 1_000 рублей
        Account accountTo = new Account(0); // Счет с нулевым балансом

        int initialBalanceFrom = accountFrom.getBalance(); // сохраняем начальные балансы
        int initialBalanceTo = accountTo.getBalance();

        boolean result = account.transfer(accountFrom, accountTo, 100);

        Assertions.assertTrue(result);
        Assertions.assertEquals(100, accountTo.getBalance());
        Assertions.assertEquals(900, accountFrom.getBalance());
    }

}
