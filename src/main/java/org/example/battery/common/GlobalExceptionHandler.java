package org.example.battery.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 全局异常处理
 */
@ResponseBody
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 异常处理方法
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public Result exceptionHandler(CustomException ex){
        String msg = ex.getMessage();
        log.error(ex.getMessage());
        return Result.error(500, msg);
    }

    @ExceptionHandler(Exception.class)
    public Result allExceptionHandler(Exception ex){
        ex.printStackTrace();
        return Result.error(500, "error message : " + ex.getMessage());
    }
}
