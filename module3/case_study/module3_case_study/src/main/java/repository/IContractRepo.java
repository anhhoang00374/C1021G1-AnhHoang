package repository;

import model.abstract_class.Contract;

import java.util.List;

public interface IContractRepo {

    List<Contract> selectAll();
}
