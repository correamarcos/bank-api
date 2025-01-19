package correa.marcos.bank_api.domain.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {
    T save(T obj);
    Optional<T> find(Long id);
    List<T> findAll();
    Boolean exists(Long id);
    void delete(T obj);
}
