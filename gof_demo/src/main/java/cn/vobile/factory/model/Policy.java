package cn.vobile.factory.model;

import java.util.List;

public class Policy {

    String command;
    String name;
    int policyid;
    int type;
    int periodid;
    List<Material> material;

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

    public int getPolicyid() {
        return policyid;
    }

    public void setPolicyid(int policyid) {
        this.policyid = policyid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPeriodid() {
        return periodid;
    }

    public void setPeriodid(int periodid) {
        this.periodid = periodid;
    }

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }

}
