package com.xiudoua.study.micro.exception;

public class FormException extends Exception{

	private static final long serialVersionUID = 1L;
    /**
     * 错误编码
     */
    private String errorCode;
    
    /**
     * 消息是否为属性文件中的Key
     */
    private boolean propertiesKey = true;
    
    /**
     * 构造一个基本异常.
     * Creates a new instance of FormException.<br/>
     * Description: TODO<br/>
     * @param msg
     */
    public FormException(String msg){
        super(msg);
    }
    
    public FormException(String errorCode,String msg){
        this(errorCode,msg,true);
    }
    
    public FormException(String errorCode,String msg,Throwable cause){
        this(errorCode, msg, cause, true);
    }
    
    public FormException(String errorCode,String msg,boolean propertiesKey){
        super(msg);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }

    public FormException(String errorCode,String msg,Throwable cause,boolean propertiesKey){
        super(msg,cause);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
    }
    
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey) {
        this.propertiesKey = propertiesKey;
    }
	
}
