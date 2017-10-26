package com.lzl.controller;

import com.lzl.bean.book.Books;
import com.lzl.bean.test.PcUserInfo;
import com.lzl.service.book.BooksService;
import com.lzl.service.test.PcUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: li_zhilei
 * @Date: create in 11:22 17/10/26.
 * @description:
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private BooksService booksService;
    @Autowired
    private PcUserInfoService pcUserInfoService;
    @RequestMapping
    public ModelMap hello(){
        ModelMap modelMap = new ModelMap();
        List<Books> booksList = booksService.listBooks();
        List<PcUserInfo> pcUserInfoList = pcUserInfoService.getPcUserInfo();
        modelMap.put("books",booksList);
        modelMap.put("userInfo",pcUserInfoList);
        return modelMap;
    }
}
