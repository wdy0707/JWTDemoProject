package cn.wdy07.demoproject.exceptionhandler;

/**
 * @author wdy
 * @create 2020-03-07 11:21
 */
public interface BaseErrorInfoInterface {

    /** 错误码*/
    String getResultCode();

    /** 错误描述*/
    String getResultMsg();
}
