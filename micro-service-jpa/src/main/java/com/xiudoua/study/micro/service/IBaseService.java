package com.xiudoua.study.micro.service;

import java.util.List;

import com.xiudoua.study.micro.exception.FormException;

public interface IBaseService<T> {

	public int add(T param) throws FormException;
    
    public int remove(T param) throws FormException;
    
    public T update(T param) throws FormException;
    
    public T getOne(T param) throws FormException;
    
    public List<T> getList(T param) throws FormException;
	
}