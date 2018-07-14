package com.idaoben.web.shiro.commom;

import com.idaoben.web.shiro.ResultStatus;

/**
 * @author Sherman 2018/7/15 2:41
 */

public class Result<T> {
    private ResultStatus status;
    private T t;

    public Result(ResultStatus status, T t) {
        this.status = status;
        this.t = t;
    }

    public Result(T t) {
        this.t = t;
    }

    public Result(ResultStatus status) {
        this.status = status;
    }

    public Result() {
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
