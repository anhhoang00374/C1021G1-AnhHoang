package service.impl;

import model.AttachService;
import repository.IAttachRepo;
import repository.impl.AttachRepoImpl;
import service.IAttachService;

import java.util.List;

public class AttachServiceImpl implements IAttachService {
    IAttachRepo iAttachRepo = new AttachRepoImpl();
    @Override
    public List<AttachService> findAll() {
        return iAttachRepo.findAll();
    }
}
