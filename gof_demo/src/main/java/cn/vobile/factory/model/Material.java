package cn.vobile.factory.model;

public class Material {

    int materialid;
    String name;
    int type;
    String img;
    String text;
    String relatedContent;
    String jumptype;
    String extenddata;

    public Material(){
        setDefaultContent();
    }
    public int getMaterialid() {
        return materialid;
    }

    public void setMaterialid(int materialid) {
        this.materialid = materialid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRelatedContent() {
        return relatedContent;
    }

    public void setRelatedContent(String relatedContent) {
        this.relatedContent = relatedContent;
    }

    public String getJumptype() {
        return jumptype;
    }

    public void setJumptype(String jumptype) {
        this.jumptype = jumptype;
    }

    public String getExtenddata() {
        return extenddata;
    }

    public void setExtenddata(String extenddata) {
        this.extenddata = extenddata;
    }

    //设置一些默认的值
    public void setDefaultContent(){
        this.setJumptype("101");
        this.setRelatedContent("default_relatedContent");
    }
}
