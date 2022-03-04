package service;

import model.Account;

public interface IAccount {
    boolean checkAccount(Account account);
    void addAccount(Account account);
}
