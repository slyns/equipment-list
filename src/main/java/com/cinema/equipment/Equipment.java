package com.cinema.equipment;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author slyns
 * @version 3/1/17.
 */
public class Equipment {
  private Property<String> type;
  private Property<Number> id;
  private Property<String> description;

  public String getType() {
    return type.getValue();
  }

  public void setType(String type) {
    this.type = new SimpleStringProperty(type);
  }

  public int getId() {
    return id.getValue().intValue();
  }

  public void setId(int id) {
    this.id = new SimpleIntegerProperty(id);
  }

  public String getDescription() {
    return description.getValue();
  }

  public void setDescription(String description) {
    this.description = new SimpleStringProperty(description);
  }

  public Property<Number> idProperty() {
    return id;
  }

  public Property<String> typeProperty() {
    return type;
  }

  public Property<String> descriptionProperty() {
    return description;
  }

  public Equipment(String type, String description) {
    this(0, type, description);
  }

  public Equipment(int id, String type, String description) {
    setId(id);
    setType(type);
    setDescription(description);
  }

  public String toString() {
    return description.getValue();
  }

  public PreparedStatement fillInsertStatement(PreparedStatement input) throws SQLException {
    input.setString(1, type.getValue());
    input.setString(2, description.getValue());

    return input;
  }
}
