package com.cinema.equipment.db;

import com.cinema.equipment.Equipment;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * @author slyns
 * @version 3/8/17.
 */
public class EquipmentChangeListener implements ChangeListener<String> {
  private Equipment observableBean;
  private DatabaseService dbService;

  public EquipmentChangeListener(Equipment observableBean, DatabaseService dbService) {
    this.observableBean = observableBean;
    this.dbService = dbService;
  }

  @Override
  public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    dbService.update(observableBean);
  }
}
