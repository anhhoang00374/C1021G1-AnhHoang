package dao;

import model.Benhan;
import model.Benhnhan;

import java.util.List;

public interface IBenhnhanDao {
    List<Benhnhan> listAllBenhnhan();
    void removeBenhnhan(String id);
    void updateBenhnhan(Benhnhan benhnhan);
}
