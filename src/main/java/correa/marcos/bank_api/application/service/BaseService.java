package correa.marcos.bank_api.application.service;

import java.util.List;

public interface BaseService<T>{
    T findById(Long id);
    List<T> findAll();
    T create(T request);
    T update(T request);
    void delete(T id);
}
