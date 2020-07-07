package edu.cnm.deepdive.browseimgur.model.entity;

import com.google.gson.annotations.Expose;

public class Tag {

  @Expose
  private String name;

  @Expose
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
