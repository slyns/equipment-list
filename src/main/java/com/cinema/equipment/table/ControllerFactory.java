package com.cinema.equipment.table;

import com.cinema.equipment.db.DatabaseService;

import javafx.util.Callback;

/**
 * @author slyns
 * @version 3/6/17.
 */
public class ControllerFactory implements Callback<Class<?>, Object> {
  private DatabaseService dbService;

  public ControllerFactory(DatabaseService dbService) {
    this.dbService = dbService;
  }
  @Override
  public Object call(Class<?> param) {
    if (param == EquipmentTableController.class) {
      return new EquipmentTableController(dbService);
    } else return null;
  }
}
