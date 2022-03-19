package repository;

import model.Account;

import java.util.List;

public interface IAccountRepo {

    boolean checkAccount(Account account);
    List<Account> findAll();

    void addAccount(Account account);
}
