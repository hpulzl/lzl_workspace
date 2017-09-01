package com.lzl.demo.pc;

/**
 * @Author: li_zhilei
 * @Date: create in 16:01 17/6/23.
 * @description:
 */
public class TestPcConfig implements PcConfig{
    public int age = 10;
    public String name="nnn";

    public static void main(String[] args) {
        PcConfig pc = new TestPcConfig();

        System.out.println("pc = " + pc.getAge());
        System.out.println("pc = " + pc.getName());
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
