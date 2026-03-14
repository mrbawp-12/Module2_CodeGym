package service;

import java.util.List;

public interface IManager<T> {
    void add(T t);
    void delete(int id);
    void update(int id, T t);
    List getAll();
}
