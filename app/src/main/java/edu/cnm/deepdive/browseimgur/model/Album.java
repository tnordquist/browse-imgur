package edu.cnm.deepdive.browseimgur.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Album {

  @Expose
  private String id;

  @Expose
  private String title;

  @Expose
  private String description;

  @Expose
  private int datetime;

  @Expose
  @SerializedName("account_url")
  private String accountUrl; // nullable

  @Expose
  private int views;

  @Expose
  private String link;

  @Expose
  private String deletehash;

  @Expose
  private int images_count;

  @Expose
  private List<Image> images;

  @Expose
  @SerializedName("in_gallery")
  private boolean inGallery;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public int getDatetime() {
    return datetime;
  }

  public void setDatetime(int datetime) {
    this.datetime = datetime;
  }

  public String getAccountUrl() {
    return accountUrl;
  }

  public void setAccountUrl(String accountUrl) {
    this.accountUrl = accountUrl;
  }

  public int getViews() {
    return views;
  }

  public void setViews(int views) {
    this.views = views;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getDeletehash() {
    return deletehash;
  }

  public void setDeletehash(String deletehash) {
    this.deletehash = deletehash;
  }

  public int getImages_count() {
    return images_count;
  }

  public void setImages_count(int images_count) {
    this.images_count = images_count;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

  public boolean isInGallery() {
    return inGallery;
  }

  public void setInGallery(boolean inGallery) {
    this.inGallery = inGallery;
  }
}
