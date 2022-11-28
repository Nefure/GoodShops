package org.nefure.goodshops.config;

import lombok.extern.slf4j.Slf4j;
import org.nefure.goodshops.dto.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author nefure
 * @since 2022/11/23 18:21
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    public Response handleRuntimeException(RuntimeException e) {
        log.error(e.toString(), e);
        return Response.fail("服务器异常");
    }

}
