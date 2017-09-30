package cn.vobile.factory.model;

import java.util.List;

public class RelatedPolicy {

    int policyid;
    String policyname;
    List<Orient> orient;

    public int getPolicyid() {
        return policyid;
    }

    public void setPolicyid(int policyid) {
        this.policyid = policyid;
    }

    public String getPolicyname() {
        return policyname;
    }

    public void setPolicyname(String policyname) {
        this.policyname = policyname;
    }

    public List<Orient> getOrient() {
        return orient;
    }

    public void setOrient(List<Orient> orient) {
        this.orient = orient;
    }
}
