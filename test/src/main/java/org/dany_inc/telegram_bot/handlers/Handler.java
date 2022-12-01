package org.dany_inc.telegram_bot.handlers;

public interface Handler<T> {
    void  choose(T t);
}
