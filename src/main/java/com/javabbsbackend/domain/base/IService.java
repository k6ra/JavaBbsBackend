package com.javabbsbackend.domain.base;

import java.util.List;

public interface IService<T> {
    List<T> find(int id);
    void entry(T model);
    void update(T model);
    void delete(T model);
}
