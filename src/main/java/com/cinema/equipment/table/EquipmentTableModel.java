package com.cinema.equipment.table;

import com.cinema.equipment.Equipment;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author slyns
 * @version 3/1/17.
 */
public class EquipmentTableModel {
  private SimpleStringProperty id;
  private SimpleStringProperty type;
  private SimpleStringProperty description;

  public EquipmentTableModel(Equipment item) {
    this.id = new SimpleStringProperty(item.getId());
    this.type = new SimpleStringProperty(item.getType().name());
    this.description = new SimpleStringProperty(item.getDescription());
  }

  Property<String> idProperty() {
    return id;
  }

  Property<String> typeProperty() {
    return type;
  }

  Property<String> descriptionProperty() {
    return description;
  }

  public void setId(String id) {
    this.id.set(id);
  }

  public String getId() {
    return this.id.get();
  }

  public void setType(String type) {
    this.type.set(type);
  }

  public String getType() {
    return this.type.get();
  }

  public void setDescription(String description) {
    this.description.set(description);
  }

  public String getDescription() {
    return this.description.get();
  }

}
