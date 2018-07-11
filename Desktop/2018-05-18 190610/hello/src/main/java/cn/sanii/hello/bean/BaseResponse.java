package cn.sanii.hello.bean;

import lombok.Data;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/4/12 17:57
 * @Description: 通用返回信息类
 */
@Data
public class BaseResponse<T> {


    private boolean ret;

    private String msg;

    private String msgCode;

    private T data;

    public BaseResponse<T> setSuccess(T data){
        this.ret=true;
        this.data=data;
        return this;
    }

    public BaseResponse<T> setError(String error){
        this.ret=false;
        this.msg=error;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", msgCode='" + msgCode + '\'' +
                ", data=" + data +
                '}';
    }
}
