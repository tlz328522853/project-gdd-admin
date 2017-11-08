package cn.hacz.edu.webexception;

/**
 * project - 异常统一处理
 *
 * @author guo 
 * @date 日期:2017年9月13日 时间:下午5:02:52
 * @JDK:version used:jdk1.7 
 * @version 3.0
 * @Description 功能模块：错误编码
 */
public enum ResultEnum {
    SUCCESS_CODE("200", "成功！"),
    FAIL_CODE("-200", "失败！");
    private String code;//错误码
    private String codeMsg;//错误信息

    public String getCode() {
        return code;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    ResultEnum(String code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }
}
