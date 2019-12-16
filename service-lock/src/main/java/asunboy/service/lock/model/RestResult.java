package asunboy.service.lock.model;

import org.springframework.util.StringUtils;

/**
 * @author LiPengJu
 * @date: 2019/12/13
 */
public class RestResult<T> {

    public static final String SUCCESS_CODE = "0";
    public static final String FAIL_CODE = "1";
    /**
     * 请求成功且业务成功 0，否则 1
     */
    private String code;
    /**
     * 请求成功返回实体
     */
    private T result;
    /**
     * 系统bug -1024，业务失败 除了-1024
     */
    private String errorCode;
    /**
     * 失败信息
     */
    private String errorMsg;

    public RestResult() {
        this.code = SUCCESS_CODE;
    }

    public RestResult(T result) {
        this.code = SUCCESS_CODE;
        this.result = result;
    }

    public RestResult(String errorCode, String errorMsg) {
        this.code = FAIL_CODE;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public static boolean isSuccess(RestResult restResult) {
        return restResult != null && StringUtils.pathEquals(SUCCESS_CODE, restResult.getCode());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
