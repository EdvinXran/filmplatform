package com.stylefeng.guns.rest.persistence.model.vo.uservo;

import java.io.Serializable;

public class UserVO implements Serializable {
    private static final long serialVersionUID = -7828560198639826925L;

    private int status;
    private Object data;

    public UserVO() {
    }

    public UserVO(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
