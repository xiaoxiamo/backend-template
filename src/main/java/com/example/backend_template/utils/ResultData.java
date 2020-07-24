package com.example.backend_template.utils;

/**
 * @ClassName ResultData 封装结果集成统一的json样式
 * @Description
 * @Author L
 * @Date Create by 2020/7/2
 */
public class ResultData<T> {
    // 信息状态码
    private Integer code;
    // 提示信息
    private String msg;
    // 返回的数据
    private T Data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}