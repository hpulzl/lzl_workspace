package com.lzl.service.common;

import com.lzl.bean.vo.BookVo;
import com.lzl.service.book.BooksService;
import com.lzl.service.test.PcUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: li_zhilei
 * @Date: create in 09:24 17/10/27.
 * @description:
 */
@Service
public class BookAndTestService {
    @Autowired
    private BooksService booksService;
    @Autowired
    private PcUserInfoService pcUserInfoService;

    @Transactional
    public void saveAndUpdate(BookVo bookVo){
        booksService.updateBooks(bookVo);
        int i = 1/0;
        pcUserInfoService.save(bookVo.getPcUserInfo());
    }
}
