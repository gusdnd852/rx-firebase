package com.hyunwoong.sample.data.entity;

import com.hyunwoong.sample.base.component.BaseEntity;

/**
 * @author : Hyunwoong
 * @when : 2019-11-15 오후 3:13
 * @homepage : https://github.com/gusdnd852
 */
public class UserEntity extends BaseEntity {
    private String id;
    private String pw;

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}