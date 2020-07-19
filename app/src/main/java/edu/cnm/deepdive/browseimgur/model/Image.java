package edu.cnm.deepdive.browseimgur.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Image implements Serializable {

  private static final long serialVersionUID = 760263467264264655L;

  public Image() {
  }

  public Image(String url) {
    this.url = url;
  }

  @Expose
  @SerializedName("id")
  private String imageId;

  @Expose
  private String title;

  @Expose
  private String description;

  @SerializedName("datetime")
  private Long imageDateTime;

  @Expose
  private String type;

  @Expose
  @SerializedName("link")
  private String url;

  private boolean animated;

  @Expose
  private Integer width;

  @Expose
  private Integer height;

  private int size;

  @Expose
  private Integer views;

  @Expose
  private Long bandwidth;

  public String getImageId() {
    return imageId;
  }

  public void setImageId(String imageId) {
    this.imageId = imageId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getImageDateTime() {
    return imageDateTime;
  }

  public void setImageDateTime(Long imageDateTime) {
    this.imageDateTime = imageDateTime;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isAnimated() {
    return animated;
  }

  public void setAnimated(boolean animated) {
    this.animated = animated;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public Integer getViews() {
    return views;
  }

  public void setViews(Integer views) {
    this.views = views;
  }

  public Long getBandwidth() {
    return bandwidth;
  }

  public void setBandwidth(Long bandwidth) {
    this.bandwidth = bandwidth;
  }

  @Override
  public String toString() {

    return title + "" + description + "" + url + "" + imageId + "" + imageDateTime;
  }
}
