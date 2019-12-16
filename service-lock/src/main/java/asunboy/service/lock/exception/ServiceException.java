package asunboy.service.lock.exception;

/**
 * @author LiPengJu
 * @date: 2019/12/16
 */
public class ServiceException extends RuntimeException {
    private final String defaultCode = "1024";
    private String code;
    private String message;

    public ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message) {
        this.code = defaultCode;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
