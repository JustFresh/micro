package com.xiudoua.study.micro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class SysRole implements GrantedAuthority{

	/**
     * serialVersionUID:TODO(描述这个变量用途).
     * 
     */
    private static final long serialVersionUID = 7254564970038502789L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Override
    public String getAuthority() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
