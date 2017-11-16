package com.lzl.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzl.SpringBoot01Application;
import com.lzl.bean.book.Books;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: li_zhilei
 * @Date: create in 09:37 17/11/16.
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBoot01Application.class)
public class GsonTest {

    @Test
    public void test(){
        Gson gson = new GsonBuilder().create();
        Books books = new Books();
        books.setImgUrl("http://com=a&hell=b");
        books.setAuthor("马尔克斯");
        books.setName("《霍乱时期的爱情》");
        String jsonStr = gson.toJson(books);
        System.out.println("jsonStr = " + jsonStr);

        String fromJson = "{\"name\":\"《霍乱时期的爱情》\",\"imgUrl\":\"http://com\\u003da\\u0026hell\\u003db\",\"author\":\"马尔克斯\"}";
        Books books1 = gson.fromJson(fromJson,Books.class);
        System.out.println("books1 = " + books1);
    }
}
