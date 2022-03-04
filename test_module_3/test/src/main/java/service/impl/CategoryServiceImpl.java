package service.impl;

import model.Category;
import repository.ICategoryRepo;
import repository.repoImpl.CategoryRepoImpl;
import service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryRepo iCategoryRepo = new CategoryRepoImpl();
    @Override
    public List<Category> findAll() {
        return iCategoryRepo.findAll();
    }
}
