package com.vgolos.VGolos.entity;

import java.util.Set;

public class Account
{
    private Long id;
    private int login;
    private String password;
    private Set<Role> roles;

    private enum Role
    {
        ADMIN,
        USER;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getLogin()
    {
        return login;
    }

    public void setLogin(int login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

}
