package com.nix.hw.lib;

import java.util.Collection;

public interface CrudService <E extends Entity>{

    void create(E obj);
    void update(E obj);
    void delete(String id);
    E read(String id);
    Collection<E> read();
}
