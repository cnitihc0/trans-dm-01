package com.trans.webapp.model;


import java.util.Date;

/**
 * @author mashaobo
 * @date 17/2/25
 * @blog http://blog.csdn.net/cnitihc0
 * @email cnitihc0@163.com
 */
public abstract class BaseEntity {
    /**
     * 状态有效
     */
    public static final int STATUS_VALID = 1;
    /**
     * 状态无效
     */
    public static final int STATUS_NO_VALID = 0;

    protected long id;
    //0:无效 1:有效
    protected int status;
    //创建信息
    protected long createById;
    protected Date createDate;
    protected long updateById;
    protected Date updateDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateById() {
        return createById;
    }

    public void setCreateById(long createById) {
        this.createById = createById;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getUpdateById() {
        return updateById;
    }

    public void setUpdateById(long updateById) {
        this.updateById = updateById;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
