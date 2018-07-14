package com.idaoben.web.shiro.entity;

import com.idaoben.web.shiro.commom.EntifyId;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author Sherman 2018/7/15 1:55
 */
@Entity
public class Role extends EntifyId implements Serializable {

    @Column(nullable = false)
    private String name;
    private List<String> permissions;
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
