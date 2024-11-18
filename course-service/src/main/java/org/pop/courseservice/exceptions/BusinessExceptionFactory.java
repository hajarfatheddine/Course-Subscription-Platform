package org.pop.courseservice.exceptions;

import lombok.RequiredArgsConstructor;
import org.pop.courseservice.enumerations.MessageCode;
import org.pop.courseservice.services.common.MessageService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessExceptionFactory {
    private final MessageService messageService;
    public BusinessException get(MessageCode code, String... args){
        return new BusinessException(code, messageService.get(code,args));
    }
}
