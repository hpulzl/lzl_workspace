package com.lzl;

import com.lzl.bean.book.Books;
import com.lzl.mapper.book.BooksMapper;
import com.lzl.service.book.TransactionService;
import com.lzl.service.test.PcUserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: li_zhilei
 * @Date: create in 16:13 17/10/10.
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBoot01Application.class)
public class TransactionTest {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private BooksMapper booksMapper;
    @Autowired
    private PcUserInfoService pcUserInfoService;

    @Test
    public void readUnCommitTest(){
        //一个事务进行查询操作，另一个事务进行插入操作。查询出的数据包括另一个事务中未提交的数据
        transactionService.listBooks();
    }

    @Test
    public void setBooksMapperTest(){
        List<Books> list = booksMapper.selectAll();
        System.out.println("list = " + list);
    }

    @Test
    public void getPcUserInfTest(){
        pcUserInfoService.getPcUserInfo();
    }
}
