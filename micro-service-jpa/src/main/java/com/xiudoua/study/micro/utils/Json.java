package com.xiudoua.study.micro.utils;

public class Json {
	
	private boolean success = false;
	
	private String msg = "";
	
	private String errorCode;
	
	private Object obj = null;

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return this.obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
