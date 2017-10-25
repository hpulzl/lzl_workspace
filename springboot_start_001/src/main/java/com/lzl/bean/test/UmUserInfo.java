package com.lzl.bean.test;

import java.util.Date;
import javax.persistence.*;

@Table(name = "um_user_info")
public class UmUserInfo {
    @Id
    @Column(name = "auto_id")
    private Long autoId;

    /**
     * userkey
     */
    @Column(name = "user_key")
    private String userKey;

    /**
     * 账号
     */
    private String account;

    /**
     * 账号类型
     */
    @Column(name = "account_type")
    private Integer accountType;

    /**
     * 站点id
     */
    @Column(name = "site_id")
    private String siteId;

    /**
     * 绑定电话号码
     */
    @Column(name = "bind_phone")
    private String bindPhone;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建人
     */
    @Column(name = "create_user_key")
    private String createUserKey;

    /**
     * 修改人
     */
    @Column(name = "modify_user_key")
    private String modifyUserKey;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * @return auto_id
     */
    public Long getAutoId() {
        return autoId;
    }

    /**
     * @param autoId
     */
    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    /**
     * 获取userkey
     *
     * @return user_key - userkey
     */
    public String getUserKey() {
        return userKey;
    }

    /**
     * 设置userkey
     *
     * @param userKey userkey
     */
    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    /**
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取账号类型
     *
     * @return account_type - 账号类型
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 设置账号类型
     *
     * @param accountType 账号类型
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取站点id
     *
     * @return site_id - 站点id
     */
    public String getSiteId() {
        return siteId;
    }

    /**
     * 设置站点id
     *
     * @param siteId 站点id
     */
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    /**
     * 获取绑定电话号码
     *
     * @return bind_phone - 绑定电话号码
     */
    public String getBindPhone() {
        return bindPhone;
    }

    /**
     * 设置绑定电话号码
     *
     * @param bindPhone 绑定电话号码
     */
    public void setBindPhone(String bindPhone) {
        this.bindPhone = bindPhone;
    }

    /**
     * 获取密码
     *
     * @return pwd - 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置密码
     *
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建人
     *
     * @return create_user_key - 创建人
     */
    public String getCreateUserKey() {
        return createUserKey;
    }

    /**
     * 设置创建人
     *
     * @param createUserKey 创建人
     */
    public void setCreateUserKey(String createUserKey) {
        this.createUserKey = createUserKey;
    }

    /**
     * 获取修改人
     *
     * @return modify_user_key - 修改人
     */
    public String getModifyUserKey() {
        return modifyUserKey;
    }

    /**
     * 设置修改人
     *
     * @param modifyUserKey 修改人
     */
    public void setModifyUserKey(String modifyUserKey) {
        this.modifyUserKey = modifyUserKey;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}