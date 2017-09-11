package cn.vobile.myDecorator;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Author: li_zhilei
 * @Date: create in 09:39 17/9/10.
 * @description:
 */
public class LowerCaseInputStreamMain {

    public static void main(String[] args) throws IOException {
        String str = "ANDDDSS";
        LowerCaseInputStream lowerCaseInputStream = new LowerCaseInputStream(new BufferedInputStream(new ByteArrayInputStream(str.getBytes())));
        int c;
        StringBuffer sb = new StringBuffer();
        while ((c = lowerCaseInputStream.read()) >= 0){
            sb.append((char) c);
        }
        System.out.println("sb.toString() = " + sb.toString());

        new LowerCaseInputStreamMain().useBufferedInputStream();
    }

    //inputStream只能按照字节来读取,因此读取中文的时候会出现乱码
    public void useBufferedInputStream() throws IOException {
        String str = "fdsggdsk";
        byte[] bytes = str.getBytes("utf-8");
        BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(bytes));
        int c ;
        StringBuffer sb = new StringBuffer();
        while ((c = bis.read()) >= 0 ){
            sb.append((char) c);
        }
        System.out.println("sb.toString() = " + sb.toString());
    }
}
