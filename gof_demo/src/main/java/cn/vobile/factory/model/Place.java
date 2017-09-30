package cn.vobile.factory.model;

import java.util.List;

public class Place {

    String command;
    String name;
    String code;
    int displaytype;
    int width;
    int height;
    List<RelatedPolicy> policy;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDisplaytype() {
        return displaytype;
    }

    public void setDisplaytype(int displaytype) {
        this.displaytype = displaytype;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<RelatedPolicy> getPolicy() {
        return policy;
    }

    public void setPolicy(List<RelatedPolicy> policy) {
        this.policy = policy;
    }

}
