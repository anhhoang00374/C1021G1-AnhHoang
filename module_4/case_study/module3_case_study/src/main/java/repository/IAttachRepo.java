package repository;

import model.AttachService;

import java.util.List;

public interface IAttachRepo {
    List<AttachService> findAll();
}
