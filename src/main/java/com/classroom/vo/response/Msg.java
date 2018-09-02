package com.classroom.vo.response;

import java.util.HashMap;
import java.util.Map;

/**
 * 传递消息的实体类
 * @author Lilamei
 * @date 2017/11/3.
 */
public class Msg {

    //消息码
    public static final int SUCCESS_CODE=1;
    public static final int FAIL_CODE=0;


    //反馈消息

    public static final String SUCCESS_MSG="success";
    public static final String FAIL_MSG="账号或密码有误，请重新输入";
    public static final String CODE_MSG="验证码有错，请重新输入";
    public static final String CSUCCESS_MSG="处理成功！";
    public static final String CFAIL_MSG="处理失败！";

    private int code;

    private String msg;

    private Map<String, Object> extend=new HashMap<String, Object>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg=msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend=extend;
    }

    public static Msg success() {
        return new Msg(SUCCESS_CODE, SUCCESS_MSG);
    }

    public static Msg fail() {
        return new Msg(FAIL_CODE, FAIL_MSG);
    }

    public static Msg successCodeMsg(){return new Msg(SUCCESS_CODE,SUCCESS_MSG);}

    public static Msg failCodeMsg(){return new Msg(FAIL_CODE,CODE_MSG);}

    public static Msg fail(int code, String msg) {
        return new Msg(code, msg);
    }


    public Msg add(String key, Object value) {
        this.extend.put(key, value);
        return this;
    }

    public Msg() {
    }

    public Msg(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public Msg(int code, String msg, Map<String, Object> extend) {
        this.code=code;
        this.msg=msg;
        this.extend=extend;
    }

    @Override
    public String toString() {
        return "Msg [code=" + code + ", msg=" + msg + ", extend=" + extend + "]";
    }
}