package com.xian.domain;

public class Result {
    private Boolean success;
    private String msg;
    private Object obj;

    public Result(Boolean success, String msg, Object obj) {
        this.success = success;
        this.msg = msg;
        this.obj = obj;
    }

    public static Result Successed(){
        return new Result(true,null,null);
    }
    public static Result Successed(String msg){
        return new Result(true,msg,null);
    }
    public static Result Successed(String msg,Object obj){
        return new Result(true,msg,obj);
    }
    public static Result failed(){
        return new Result(false,null,null);
    }
    public static Result failed(String msg){
        return new Result(false,msg,null);
    }
    public static Result failed(String msg,Object obj){
        return new Result(false,msg,obj);
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public Object getObj() {
        return obj;
    }
}
