package org.dany_inc.telegram_bot.cache;

import java.util.List;

public interface Cache <T> {
    void add(T t);
    void remove(T t);
    T findBy(Long id);
    List<T> getAll();
}
