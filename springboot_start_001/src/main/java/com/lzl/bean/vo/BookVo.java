package com.lzl.bean.vo;

import com.lzl.bean.book.Books;
import com.lzl.bean.test.PcUserInfo;

/**
 * @Author: li_zhilei
 * @Date: create in 09:26 17/10/27.
 * @description:
 */
public class BookVo extends Books{
    private PcUserInfo pcUserInfo;

    public PcUserInfo getPcUserInfo() {
        return pcUserInfo;
    }

    public void setPcUserInfo(PcUserInfo pcUserInfo) {
        this.pcUserInfo = pcUserInfo;
    }
}
