package com.jeniatyt.bot.mapper.iface;

public interface Mapper<M, F, O> {
    M toMessage(O dto);
    
    F toFotoMessage(O dto);
    
    O from(M message);
}
