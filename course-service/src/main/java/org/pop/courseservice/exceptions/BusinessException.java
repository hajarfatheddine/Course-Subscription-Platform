package org.pop.courseservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.pop.courseservice.enumerations.MessageCode;

@AllArgsConstructor
@Getter
@ToString
public class BusinessException extends Exception{
    private final MessageCode code;
    private final String message;
}
