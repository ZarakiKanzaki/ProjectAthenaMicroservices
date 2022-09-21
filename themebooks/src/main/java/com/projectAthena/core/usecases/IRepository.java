package com.projectAthena.core.usecases;

public interface IRepository<T, TId> {
    T findByKey(TId id);
    T FindByCode(String code);
    T getByKey(TId id);
    T getByCode(String code);
    boolean isUniqueByCode(String code);
    void add(T entity);
    void saveChanges();
}
