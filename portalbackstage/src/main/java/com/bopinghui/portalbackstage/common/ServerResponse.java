package com.bopinghui.portalbackstage.common;

/**
 * ${DESCRIPTION}
 *
 * @author kakasun
 * @create 2018-03-02 下午4:27
 */
public class ServerResponse <T> {
    int statu;
    String message;
    T data;

    public ServerResponse(int statu){
        this.statu = statu;
    }

    public ServerResponse(int statu,String message){
        this.statu = statu;
        this.message = message;
    }

    public ServerResponse(int statu,String message,T data){
        this.statu = statu;
        this.message = message;
        this.data = data;
    }

    public static ServerResponse ofSucess(){
        return new ServerResponse(ResponseStatus.SUCESS);
    }
    public static ServerResponse ofSucess(Object data){
        ServerResponse response = new ServerResponse(ResponseStatus.SUCESS);
        response.setData(data);
        return response;
    }

    public static ServerResponse statuMessage(int statu,String message){
        return new ServerResponse(statu,message);
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    interface ResponseStatus{
        /**
         * 成功
         */
        int SUCESS = 200;
    }
}
