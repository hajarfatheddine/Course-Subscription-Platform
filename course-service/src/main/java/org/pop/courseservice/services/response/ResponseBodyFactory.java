package org.pop.courseservice.services.response;


import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.pop.courseservice.enumerations.MessageCode;
import org.pop.courseservice.services.common.MessageService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Generated
public class ResponseBodyFactory<T> {
    private final MessageService messageService;
    public ResponseBody<T> get(MessageCode code, T result){
        return ResponseBody.<T>builder().code(code.name()).message(messageService.get(code)).result(result).build();
    }

}
