package cn.asunboy;

import org.springframework.core.NestedRuntimeException;

/**
 * 系统异常
 * @author LiPengJu
 * @date 2018/8/4
 */
public class ApplicationException extends NestedRuntimeException {

    private final String errorCode;

    public ApplicationException(String msg) {
        this(msg,"");
    }

    public ApplicationException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
