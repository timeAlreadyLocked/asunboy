package asunboy.service.lock.exception;

import asunboy.service.lock.model.RestResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author LiPengJu
 * @date: 2019/12/16
 */
@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(ServiceException.class)
    public RestResult serviceException(ServiceException e) {
        return new RestResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public RestResult exception(Exception e){
        e.printStackTrace();
        return new RestResult("-1024",e.getMessage());
    }
}
