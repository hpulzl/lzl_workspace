package com.lzl.bean.test;

import javax.persistence.*;

@Table(name = "pc_user_info")
public class PcUserInfo {
    @Id
    private Integer uid;

    /**
     * 用户email
     */
    private String email;

    /**
     * 用户名 在ucenter登记
     */
    private String username;

    /**
     * 显示名
     */
    private String showname;

    /**
     * 用户密码-伪. 登录时对比ucenter中密码
     */
    private String password;

    /**
     * 用户状态 是否锁定或其他
     */
    private Boolean status;

    /**
     * email 是否认证
     */
    private Boolean emailstatus;

    /**
     * 会员图像审核：1已审核，2未审核，3未上传
     */
    private Boolean avatarstatus;

    /**
     * 用户是否经过视频认证
     */
    private Boolean videophotostatus;

    /**
     * 用户组
     */
    private Short groupid;

    /**
     * 是否定绑微博
     */
    private Boolean isblog;

    /**
     * 附加用户组的有效时间
     */
    private Integer groupexpiry;

    /**
     * 附加用户组
     */
    private String extgroupids;

    /**
     * 注册时间
     */
    private Integer regdate;

    /**
     * 用户积分
     */
    private Integer credits;

    private Integer accredits;

    /**
     * 关注人数
     */
    private Integer follow;

    /**
     * 粉丝数
     */
    private Integer fans;

    /**
     * 人气
     */
    private Integer popularity;

    /**
     * 是否有新短消息 
     */
    private Short newpm;

    /**
     * 新提醒数目 
     */
    private Short newprompt;

    /**
     * 注册ip
     */
    @Column(name = "reg_ip")
    private String regIp;

    /**
     * 注册地
     */
    @Column(name = "reg_location")
    private String regLocation;

    /**
     * <影视vip>过期时间
     */
    @Column(name = "vip_endtime")
    private Integer vipEndtime;

    /**
     * <求索vip>过期时间
     */
    @Column(name = "vip_qs_endtime")
    private Integer vipQsEndtime;

    @Column(name = "alipay_sign")
    private String alipaySign;

    /**
     * ðððððð
     */
    private String inputer;

    /**
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取用户email
     *
     * @return email - 用户email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户email
     *
     * @param email 用户email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户名 在ucenter登记
     *
     * @return username - 用户名 在ucenter登记
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名 在ucenter登记
     *
     * @param username 用户名 在ucenter登记
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取显示名
     *
     * @return showname - 显示名
     */
    public String getShowname() {
        return showname;
    }

    /**
     * 设置显示名
     *
     * @param showname 显示名
     */
    public void setShowname(String showname) {
        this.showname = showname;
    }

    /**
     * 获取用户密码-伪. 登录时对比ucenter中密码
     *
     * @return password - 用户密码-伪. 登录时对比ucenter中密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码-伪. 登录时对比ucenter中密码
     *
     * @param password 用户密码-伪. 登录时对比ucenter中密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户状态 是否锁定或其他
     *
     * @return status - 用户状态 是否锁定或其他
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置用户状态 是否锁定或其他
     *
     * @param status 用户状态 是否锁定或其他
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取email 是否认证
     *
     * @return emailstatus - email 是否认证
     */
    public Boolean getEmailstatus() {
        return emailstatus;
    }

    /**
     * 设置email 是否认证
     *
     * @param emailstatus email 是否认证
     */
    public void setEmailstatus(Boolean emailstatus) {
        this.emailstatus = emailstatus;
    }

    /**
     * 获取会员图像审核：1已审核，2未审核，3未上传
     *
     * @return avatarstatus - 会员图像审核：1已审核，2未审核，3未上传
     */
    public Boolean getAvatarstatus() {
        return avatarstatus;
    }

    /**
     * 设置会员图像审核：1已审核，2未审核，3未上传
     *
     * @param avatarstatus 会员图像审核：1已审核，2未审核，3未上传
     */
    public void setAvatarstatus(Boolean avatarstatus) {
        this.avatarstatus = avatarstatus;
    }

    /**
     * 获取用户是否经过视频认证
     *
     * @return videophotostatus - 用户是否经过视频认证
     */
    public Boolean getVideophotostatus() {
        return videophotostatus;
    }

    /**
     * 设置用户是否经过视频认证
     *
     * @param videophotostatus 用户是否经过视频认证
     */
    public void setVideophotostatus(Boolean videophotostatus) {
        this.videophotostatus = videophotostatus;
    }

    /**
     * 获取用户组
     *
     * @return groupid - 用户组
     */
    public Short getGroupid() {
        return groupid;
    }

    /**
     * 设置用户组
     *
     * @param groupid 用户组
     */
    public void setGroupid(Short groupid) {
        this.groupid = groupid;
    }

    /**
     * 获取是否定绑微博
     *
     * @return isblog - 是否定绑微博
     */
    public Boolean getIsblog() {
        return isblog;
    }

    /**
     * 设置是否定绑微博
     *
     * @param isblog 是否定绑微博
     */
    public void setIsblog(Boolean isblog) {
        this.isblog = isblog;
    }

    /**
     * 获取附加用户组的有效时间
     *
     * @return groupexpiry - 附加用户组的有效时间
     */
    public Integer getGroupexpiry() {
        return groupexpiry;
    }

    /**
     * 设置附加用户组的有效时间
     *
     * @param groupexpiry 附加用户组的有效时间
     */
    public void setGroupexpiry(Integer groupexpiry) {
        this.groupexpiry = groupexpiry;
    }

    /**
     * 获取附加用户组
     *
     * @return extgroupids - 附加用户组
     */
    public String getExtgroupids() {
        return extgroupids;
    }

    /**
     * 设置附加用户组
     *
     * @param extgroupids 附加用户组
     */
    public void setExtgroupids(String extgroupids) {
        this.extgroupids = extgroupids;
    }

    /**
     * 获取注册时间
     *
     * @return regdate - 注册时间
     */
    public Integer getRegdate() {
        return regdate;
    }

    /**
     * 设置注册时间
     *
     * @param regdate 注册时间
     */
    public void setRegdate(Integer regdate) {
        this.regdate = regdate;
    }

    /**
     * 获取用户积分
     *
     * @return credits - 用户积分
     */
    public Integer getCredits() {
        return credits;
    }

    /**
     * 设置用户积分
     *
     * @param credits 用户积分
     */
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    /**
     * @return accredits
     */
    public Integer getAccredits() {
        return accredits;
    }

    /**
     * @param accredits
     */
    public void setAccredits(Integer accredits) {
        this.accredits = accredits;
    }

    /**
     * 获取关注人数
     *
     * @return follow - 关注人数
     */
    public Integer getFollow() {
        return follow;
    }

    /**
     * 设置关注人数
     *
     * @param follow 关注人数
     */
    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    /**
     * 获取粉丝数
     *
     * @return fans - 粉丝数
     */
    public Integer getFans() {
        return fans;
    }

    /**
     * 设置粉丝数
     *
     * @param fans 粉丝数
     */
    public void setFans(Integer fans) {
        this.fans = fans;
    }

    /**
     * 获取人气
     *
     * @return popularity - 人气
     */
    public Integer getPopularity() {
        return popularity;
    }

    /**
     * 设置人气
     *
     * @param popularity 人气
     */
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    /**
     * 获取是否有新短消息 
     *
     * @return newpm - 是否有新短消息 
     */
    public Short getNewpm() {
        return newpm;
    }

    /**
     * 设置是否有新短消息 
     *
     * @param newpm 是否有新短消息 
     */
    public void setNewpm(Short newpm) {
        this.newpm = newpm;
    }

    /**
     * 获取新提醒数目 
     *
     * @return newprompt - 新提醒数目 
     */
    public Short getNewprompt() {
        return newprompt;
    }

    /**
     * 设置新提醒数目 
     *
     * @param newprompt 新提醒数目 
     */
    public void setNewprompt(Short newprompt) {
        this.newprompt = newprompt;
    }

    /**
     * 获取注册ip
     *
     * @return reg_ip - 注册ip
     */
    public String getRegIp() {
        return regIp;
    }

    /**
     * 设置注册ip
     *
     * @param regIp 注册ip
     */
    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    /**
     * 获取注册地
     *
     * @return reg_location - 注册地
     */
    public String getRegLocation() {
        return regLocation;
    }

    /**
     * 设置注册地
     *
     * @param regLocation 注册地
     */
    public void setRegLocation(String regLocation) {
        this.regLocation = regLocation;
    }

    /**
     * 获取<影视vip>过期时间
     *
     * @return vip_endtime - <影视vip>过期时间
     */
    public Integer getVipEndtime() {
        return vipEndtime;
    }

    /**
     * 设置<影视vip>过期时间
     *
     * @param vipEndtime <影视vip>过期时间
     */
    public void setVipEndtime(Integer vipEndtime) {
        this.vipEndtime = vipEndtime;
    }

    /**
     * 获取<求索vip>过期时间
     *
     * @return vip_qs_endtime - <求索vip>过期时间
     */
    public Integer getVipQsEndtime() {
        return vipQsEndtime;
    }

    /**
     * 设置<求索vip>过期时间
     *
     * @param vipQsEndtime <求索vip>过期时间
     */
    public void setVipQsEndtime(Integer vipQsEndtime) {
        this.vipQsEndtime = vipQsEndtime;
    }

    /**
     * @return alipay_sign
     */
    public String getAlipaySign() {
        return alipaySign;
    }

    /**
     * @param alipaySign
     */
    public void setAlipaySign(String alipaySign) {
        this.alipaySign = alipaySign;
    }

    /**
     * 获取ðððððð
     *
     * @return inputer - ðððððð
     */
    public String getInputer() {
        return inputer;
    }

    /**
     * 设置ðððððð
     *
     * @param inputer ðððððð
     */
    public void setInputer(String inputer) {
        this.inputer = inputer;
    }
}