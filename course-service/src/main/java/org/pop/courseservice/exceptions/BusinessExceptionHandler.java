package org.pop.courseservice.exceptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pop.courseservice.services.common.MessageService;
import org.pop.courseservice.services.response.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.pop.courseservice.enumerations.MessageCode.INTERNAL_SERVER_ERROR;


@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class BusinessExceptionHandler {
    private final MessageService messageService;
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseBody<Object>> handle(BusinessException e){
        ResponseBody<Object> result = ResponseBody.builder()
                .code(e.getCode().name())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    @ExceptionHandler(Throwable.class)
    private ResponseEntity<ResponseBody<Object>> handle(Throwable throwable){
        String message = messageService.get(INTERNAL_SERVER_ERROR);
        log.error("Exception status:"+ INTERNAL_SERVER_ERROR.name());
        log.error("Exception stack trace: " + throwable);
        ResponseBody<Object> responseBody = ResponseBody.builder()
                .code(INTERNAL_SERVER_ERROR.name())
                .message(message)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

}
