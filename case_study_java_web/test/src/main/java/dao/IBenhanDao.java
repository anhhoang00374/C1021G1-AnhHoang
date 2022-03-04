package dao;

import model.Benhan;

import java.util.List;

public interface IBenhanDao {
    List<Benhan> listAllBenhan();
    void removeBenhan(String id);
    void updateBenhan(Benhan benhan);
}
