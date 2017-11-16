package com.lzl.bean.book;

import java.util.Date;
import javax.persistence.*;

public class Books {
    @Id
    private Integer id;

    private String name;

    @Column(name = "img_url")
    private String imgUrl;

    private Double score;

    private String author;

    @Column(name = "publish_company")
    private String publishCompany;

    @Column(name = "publish_at")
    private String publishAt;

    @Column(name = "create_at")
    private Date createAt;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return img_url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return score
     */
    public Double getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return publish_company
     */
    public String getPublishCompany() {
        return publishCompany;
    }

    /**
     * @param publishCompany
     */
    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    /**
     * @return publish_at
     */
    public String getPublishAt() {
        return publishAt;
    }

    /**
     * @param publishAt
     */
    public void setPublishAt(String publishAt) {
        this.publishAt = publishAt;
    }

    /**
     * @return create_at
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * @param createAt
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Books{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append(", score=").append(score);
        sb.append(", author='").append(author).append('\'');
        sb.append(", publishCompany='").append(publishCompany).append('\'');
        sb.append(", publishAt='").append(publishAt).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append('}');
        return sb.toString();
    }
}