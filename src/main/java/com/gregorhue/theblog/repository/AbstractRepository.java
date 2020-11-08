package com.gregorhue.theblog.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by gregorhue on 03.10.2020.
 */
public abstract class AbstractRepository<T extends Serializable> {

    private Class<T> clazz;

    @Inject
    EntityManager entityManager;

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(Long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> collection = criteriaQuery.from(clazz);
        criteriaQuery.select(collection);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void saveNewEntity(T entity) {   
            entityManager.persist(entity);
    }
    
    public void updateEntry(T entity) {
    	entityManager.merge(entity);
    }

    public void delete(T entity) {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Long entityId) {
        T entity = findOne(entityId);
        delete(entity);
    }
}
