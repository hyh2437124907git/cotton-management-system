package com.common.rest;

/**
 * 响应代码枚举 只选取极少几个
 *
 * @author ankelen
 * @date 2020-10-13 17:34
 */
public enum RestCode implements IRestCode {
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 操作失败
     */
    FAILURE(400, "操作失败"),

    /**
     * 某次请求传入的数据在处理时出现问题
     */
    SERVICE_UNAVAILABLE(503,"服务器临时出错"),

    /**
     * 打开指定工程时出现错误
     */
    OPEN_FAIL(550,"工程打开失败"),

    /**
     * 资源未找到
     */
    NOT_FOUND(404, "资源未找到"),
    /**
     * 内部错误
     */
    INTERNAL_SERVER_ERROR(500, "内部错误");


    /**
     * 响应码
     */
    final int code;

    /**
     * 响应信息
     */
    final String msg;

    RestCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
