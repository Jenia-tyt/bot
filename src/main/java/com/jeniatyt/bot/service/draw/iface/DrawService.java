package com.jeniatyt.bot.service.draw.iface;

import com.jeniatyt.bot.model.dto.CompanyMessageDto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.IOException;

public interface DrawService {
    InputFile draw(CompanyMessageDto dto) throws IOException;
}
