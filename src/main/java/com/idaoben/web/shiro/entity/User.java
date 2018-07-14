package com.idaoben.web.shiro.entity;

import com.idaoben.web.shiro.commom.EntifyId;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Sherman 2018/7/15 1:35
 */
@Entity
public class User extends EntifyId {

    @Column(nullable = false)
    private String name;
    private String password;
    private String encodePassword;
    private Boolean lock;

    @ManyToMany(mappedBy = "roles", targetEntity = Role.class)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )
    private Set<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncodePassword() {
        return encodePassword;
    }

    public void setEncodePassword(String encodePassword) {
        this.encodePassword = encodePassword;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
