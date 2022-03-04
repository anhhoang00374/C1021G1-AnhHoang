package service;

import model.abstract_class.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> selectAll();
}
