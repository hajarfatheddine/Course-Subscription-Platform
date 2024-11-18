package org.pop.courseservice.services.common;

import lombok.RequiredArgsConstructor;
import org.pop.courseservice.enumerations.MessageCode;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageSource messageSource;

    public String get(MessageCode code, String... args){
        return messageSource.getMessage(code.name(), args, Locale.ENGLISH);
    }

}
