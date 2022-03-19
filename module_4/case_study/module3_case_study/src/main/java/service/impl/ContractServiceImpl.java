package service.impl;

import model.abstract_class.Contract;
import repository.IContractRepo;
import repository.impl.ContractRepoImpl;
import service.IContractService;

import java.util.List;

public class ContractServiceImpl implements IContractService {
    IContractRepo iContractRepo = new ContractRepoImpl();
    @Override
    public List<Contract> selectAll() {
        return  iContractRepo.selectAll();
    }
}
