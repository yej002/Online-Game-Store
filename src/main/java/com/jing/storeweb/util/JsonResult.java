package com.jing.storeweb.util;

import java.io.Serializable;

/**
 * Set response to front-end
 *
 * @param <E> type
 */
public class JsonResult<E> implements Serializable {
    private Integer state;
    private String message;
    private E data;

    public JsonResult() {
        super();
    }

    public JsonResult(Integer state) {
        super();
        this.state = state;
    }

    //If exception exist, get the exception message
    public JsonResult(Throwable e) {
        super();
        this.message = e.getMessage();
    }

    // get status and data from controller
    public JsonResult(Integer state, E data) {
        super();
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}

