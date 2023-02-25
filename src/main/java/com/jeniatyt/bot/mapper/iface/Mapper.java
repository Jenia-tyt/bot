package com.jeniatyt.bot.mapper.iface;

public interface Mapper<T,O> {
    T to(O dto);
    O from(T target);
}
