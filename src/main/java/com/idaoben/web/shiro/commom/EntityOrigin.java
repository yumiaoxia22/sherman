package com.idaoben.web.shiro.commom;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @author Sherman 2018/7/15 1:36
 */

public class EntityOrigin extends EntifyId implements Serializable {

    @Column
    private ZonedDateTime createTime;

    @Column
    private ZonedDateTime updateTime;


    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
