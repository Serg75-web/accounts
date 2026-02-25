package ru.netology.javaqadiplom;

public class Account {
    protected int balance;
    protected int rate;

    public Account(int rub) {
        if (rub < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = rub;
    }

    public Account() {
    }

    public boolean pay(int amount) {
        if (amount <= 0 || amount > balance) {
            return false; // Нельзя списывать отрицательные суммы или превышающие баланс
        }
        balance -= amount; // Уменьшаем баланс
        return true; // Списание успешно
    }

    public boolean add(int amount) {
        if (amount <= 0) {
            return false; // Нельзя добавлять отрицательные суммы
        }
        balance += amount; // Увеличиваем баланс
        return true; // Пополнение успешно
    }

    public int yearChange() {
        return (int) (balance * rate / 100.0); // Пример расчета процентов
    }

    public int getBalance() {
        return balance;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
