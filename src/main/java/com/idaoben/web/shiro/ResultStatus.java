package com.idaoben.web.shiro;

/**
 * @author Sherman 2018/7/15 2:46
 */

public enum ResultStatus {
    ERROR, SUCCESS;
    private Integer code;
    private String Message;
    private String Command;

    ResultStatus(Integer code, String message, String command) {
        this.code = code;
        Message = message;
        Command = command;
    }

    ResultStatus(Integer code, String message) {
        this.code = code;
        Message = message;
    }

    ResultStatus() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }
}
