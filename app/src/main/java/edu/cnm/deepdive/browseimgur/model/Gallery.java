package edu.cnm.deepdive.browseimgur.model;

import com.google.gson.annotations.Expose;
import java.util.List;

public class Gallery {

  private String id;

  @Expose
  private String title;

  @Expose
  private String description;

  private long datetime;

  private String link;

  private List<Tag> tags;

  @Expose
  private List<Image> images;

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

  public long getDatetime() {
    return datetime;
  }

  public void setDatetime(long datetime) {
    this.datetime = datetime;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }

  @Override
  public String toString() {
    return title + description + images.toString();
  }

  public static class SearchResult {

    @Expose
    private List<Gallery> data;

    public List<Gallery> getData() {
      return data;
    }

    public void setData(List<Gallery> data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "SearchResult{" +
          "data=" + data.toString();
    }
  }


}
