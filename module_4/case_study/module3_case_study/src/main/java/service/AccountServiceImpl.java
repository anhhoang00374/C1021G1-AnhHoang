package service;

import model.Account;
import repository.IAccountRepo;
import repository.impl.AccountRepoImpl;

public class AccountServiceImpl implements IAccount{
    IAccountRepo iAccountRepo = new AccountRepoImpl();
    @Override
    public boolean checkAccount(Account account) {
        return iAccountRepo.checkAccount(account);
    }

    @Override
    public void addAccount(Account account) {
        iAccountRepo.addAccount(account);
    }
}
