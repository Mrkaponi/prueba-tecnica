package com.example.ship.repository.ports;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface BaseCrudPort<T, ID> {
    default T saveOrUpdate(T object) {
        return null;
    }

    default Optional<T> findById(ID id) {
        return Optional.empty();
    }

    default void safeDeleteById(ID id) {
    }

    default void deleteById(ID id) {
    }

    default List<T> findAll(){
        return Collections.emptyList();
    }
}
