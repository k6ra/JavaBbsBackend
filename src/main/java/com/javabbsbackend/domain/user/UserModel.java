package com.javabbsbackend.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javabbsbackend.domain.base.IModel;

public class UserModel implements IModel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("loginname")
    private String loginname;
    @JsonProperty("password")
    private String password;

    public UserModel() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLoginName() { return loginname; }
    public void setLoginName(String loginName) { this.loginname = loginName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
