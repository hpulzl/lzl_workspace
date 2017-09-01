package util;

import org.springframework.util.Assert;

/**
 * @Author: li_zhilei
 * @Date: create in 10:48 17/5/3.
 * @description:
 */
public class UsableUtils {
    public static void main(String[] args) {
        //Assert是spring封装的判断obj为空的工具类
        Assert.notNull(new String(),"obj 不允许为空");
    }
}
