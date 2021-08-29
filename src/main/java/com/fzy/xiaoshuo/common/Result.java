package com.fzy.xiaoshuo.common;

import lombok.Data;
// 消息封装类
@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    public static Result success(int code,String msg,Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static Result success(Object data){
        return success(200,"操作成功",data);
    }
    public static Result error(int code,String msg,Object data){
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
    public static Result error(String msg,Object data){
        return error(400,msg,data);
    }
    public static Result error(String msg){
        return error(400,msg,null);
    }
}
