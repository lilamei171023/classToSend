package com.classroom.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lilamei
 * @date 2017/11/2 20:55
 */
public class Userlogin  implements Serializable{
    private int userloginId;
    private String target;
    private String userloginNumber;
    private String userloginPwd;
    private Date createAt;
    private Date updateAt;
    private boolean deleted;


    public Userlogin() {
    }

    public Userlogin(int userloginId, String target, String userloginNumber, String userloginPwd, Date createAt, Date updateAt, boolean deleted) {
        this.userloginId = userloginId;
        this.target = target;
        this.userloginNumber = userloginNumber;
        this.userloginPwd = userloginPwd;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.deleted = deleted;
    }

    public int getUserloginId() {
        return userloginId;
    }

    public void setUserloginId(int userloginId) {
        this.userloginId = userloginId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUserloginNumber() {
        return userloginNumber;
    }

    public void setUserloginNumber(String userloginNumber) {
        this.userloginNumber = userloginNumber;
    }

    public String getUserloginPwd() {
        return userloginPwd;
    }

    public void setUserloginPwd(String userloginPwd) {
        this.userloginPwd = userloginPwd;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Userlogin{" +
                "userloginId=" + userloginId +
                ", target='" + target + '\'' +
                ", userloginNumber='" + userloginNumber + '\'' +
                ", userloginPwd='" + userloginPwd + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", deleted=" + deleted +
                '}';
    }
}
