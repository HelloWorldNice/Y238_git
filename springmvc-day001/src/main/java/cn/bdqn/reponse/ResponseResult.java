package cn.bdqn.reponse;

public class ResponseResult {

    // 状态码
    private Integer code;

    // 返回的数据
    private Object data;

    // 返回的消息
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
