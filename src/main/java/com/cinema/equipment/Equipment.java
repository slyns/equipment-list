package com.cinema.equipment;

/**
 * @author slyns
 * @version 3/1/17.
 */
public class Equipment {
  private Type type;
  private String id;
  private String description;

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Equipment(Type type, String description) {
    this.type = type;
    this.description = description;
  }

  public String toString() {
    return description;
  }
}
