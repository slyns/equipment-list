package com.cinema.equipment;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author slyns
 * @version 3/1/17.
 */
public class Equipment {
  private String type;
  private int id;
  private String description;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Equipment(String type, String description) {
    this(0, type, description);
  }

  public Equipment(int id, String type, String description) {
    this.id = id;
    this.type = type;
    this.description = description;
  }

  public String toString() {
    return description;
  }

  public PreparedStatement fillInsertStatement(PreparedStatement input) throws SQLException {
    input.setString(1, type);
    input.setString(2, description);

    return input;
  }
}
