package com.example.backend_template.constant;

/**
 * @Description
 * @Author L
 * @Date Create by 2020/7/2
 */
public enum ResultCode {
    // 成功
    SUCCESS(200),
    // 失败
    FAIL(400),
    // 未认证（签名错误）
    UNAUTHORIZED(401),
    // 接口不存在
    NOT_FOUND(404),
    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}