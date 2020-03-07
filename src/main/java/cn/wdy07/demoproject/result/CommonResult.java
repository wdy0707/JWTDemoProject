package cn.wdy07.demoproject.result;

import cn.wdy07.demoproject.exceptionhandler.BaseErrorInfoInterface;
import cn.wdy07.demoproject.exceptionhandler.CommonEnum;
import com.alibaba.fastjson.JSONObject;

/**
 * @author wdy
 * @create 2020-03-07 11:25
 */
public class CommonResult {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public CommonResult() {
    }

    public CommonResult(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 成功
     *
     * @return
     */
    public static CommonResult success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static CommonResult success(Object data) {
        CommonResult rb = new CommonResult();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMessage(CommonEnum.SUCCESS.getResultMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 失败
     */
    public static CommonResult error(BaseErrorInfoInterface errorInfo) {
        CommonResult rb = new CommonResult();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static CommonResult error(String code, String message) {
        CommonResult rb = new CommonResult();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static CommonResult error( String message) {
        CommonResult rb = new CommonResult();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
