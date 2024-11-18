package org.pop.courseservice.services.response;

import lombok.Builder;
import lombok.Generated;

@Generated
@Builder
public record ResponseBody<T>(String code, String message, T result) {
}
