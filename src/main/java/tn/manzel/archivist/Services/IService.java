package tn.manzel.archivist.Services;

import java.util.List;

public interface IService <T,ID> {
    T save(T entity);
    T findById(ID id);
    boolean deleteById(ID id);
    List<T> findAll();
}
