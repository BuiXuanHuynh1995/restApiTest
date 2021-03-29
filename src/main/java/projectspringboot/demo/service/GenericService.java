package projectspringboot.demo.service;

import projectspringboot.demo.model.Xe;

import java.util.List;

public interface GenericService<T> {
    List<T> findAll();
    T save(T t);
    T findById(long id);
    void delete(T t);
    void deleteById(long id);
}
