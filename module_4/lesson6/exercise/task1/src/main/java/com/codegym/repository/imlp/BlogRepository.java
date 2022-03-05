package com.codegym.repository.imlp;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Repository
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void add(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public List<Blog> findAdd() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog as b",Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog as c where c.id=:id",Blog.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if(blog!=null){
            entityManager.remove(blog);
        }

    }

    @Override
    public void edit(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public List<Blog> search() {
        TypedQuery<Blog> query = entityManager.createNamedQuery("findByName",Blog.class);
        query.setParameter("name","hh");
        return query.getResultList();
    }
}
