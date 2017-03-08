package com.cinema.equipment.table;

import com.cinema.equipment.Equipment;
import com.cinema.equipment.db.DatabaseService;

import java.net.URL;
import java.util.ResourceBundle;

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
  private ObservableList<Equipment> items;

  @FXML
  private ChoiceBox<String> typeChoice;
  @FXML
  private TextField descriptionField;

  @FXML
  private TableView<Equipment> records;

  private DatabaseService dbService;

  public EquipmentTableController(DatabaseService dbService) {
    this.dbService = dbService;
  }

  @Override
  public void handle(ActionEvent event) {
    items.add(dbService.add(new Equipment(typeChoice.getValue(), descriptionField.getText())));
    typeChoice.setValue("Відео");
    descriptionField.clear();
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    items = FXCollections.observableList(dbService.getAll());
    records.setItems(items);

  }
}
