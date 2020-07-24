package com.example.backend_template.utils;

/**
 * @ClassName ResultUtils
 * @Description
 * @Author L
 * @Date Create by 2020/7/2
 */
public class ResultUtils {
    // 统一结果集对象
    private static ResultData<Object> resultData = new ResultData<>();

    /**
     * 成功时调用的函数
     *
     * @param object 要返回的对象
     * @return
     */
    public static ResultData<Object> success(Object object) {
        resultData.setCode(0);
        resultData.setMsg("success");
        resultData.setData(object);
        return resultData;
    }

    /**
     * 成功时，如果没有要返回的对象，调用此方法
     *
     * @return
     */
    public static ResultData<Object> success() {
        return success(null);
    }

    /**
     * 失败时调用的函数
     *
     * @param code 要返回的状态码
     * @param msg  要返回的信息
     * @return
     */
    public static ResultData<Object> fail(Integer code, String msg) {
        resultData.setCode(code);
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 失败时调用的函数
     *
     * @param code   要返回的状态码
     * @param msg    要返回的信息
     * @param object 要返回的具体错误信息
     * @return
     */
    public static ResultData<Object> fail(Integer code, String msg, Object object) {
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setData(object);
        return resultData;
    }
}