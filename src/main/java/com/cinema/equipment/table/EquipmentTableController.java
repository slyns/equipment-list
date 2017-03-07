package com.cinema.equipment.table;

import com.cinema.equipment.Equipment;
import com.cinema.equipment.Type;
import com.cinema.equipment.db.DatabaseService;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author slyns
 * @version 3/4/17.
 */
public class EquipmentTableController implements EventHandler<ActionEvent>, Initializable {
  private int number = 1;
  private ObservableList<EquipmentTableModel> items;

  @FXML
  private ChoiceBox<Type> typeChoice;
  @FXML
  private TextField descriptionField;

  @FXML
  private TableView<EquipmentTableModel> records;

  private DatabaseService dbService;

  public EquipmentTableController(DatabaseService dbService) {
    this.dbService = dbService;
  }

  @Override
  public void handle(ActionEvent event) {
    Equipment newItem = dbService.add(new Equipment(typeChoice.getValue(), descriptionField.getText()));
    items.add(new EquipmentTableModel(newItem));
    typeChoice.setValue(Type.VIDEO);
    descriptionField.clear();
  }

  public ObservableList<EquipmentTableModel> getItems() {
    return items;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    items = FXCollections.observableList(dbService.getAll().stream().map(EquipmentTableModel::new).collect(Collectors.toList()));
    records.setItems(items);

  }
}
