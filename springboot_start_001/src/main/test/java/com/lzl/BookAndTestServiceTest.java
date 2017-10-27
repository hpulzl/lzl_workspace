package com.lzl;

import com.lzl.bean.test.PcUserInfo;
import com.lzl.bean.vo.BookVo;
import com.lzl.service.common.BookAndTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author: li_zhilei
 * @Date: create in 09:31 17/10/27.
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBoot01Application.class)
public class BookAndTestServiceTest {

    @Autowired
    private BookAndTestService bookAndTestService;

    @Test
    public void bookTest(){
        BookVo bookVo = new BookVo();
        bookVo.setId(2);
        bookVo.setName("fds");
        bookVo.setAuthor("dffddf");
        bookVo.setImgUrl("http://cddsa.com");
        PcUserInfo pcUserInfo = new PcUserInfo();
        pcUserInfo.setEmail("824");
        pcUserInfo.setEmailstatus(true);
        pcUserInfo.setFans(100);
        pcUserInfo.setExtgroupids("hdshka");
        bookAndTestService.saveAndUpdate(bookVo);
    }

}