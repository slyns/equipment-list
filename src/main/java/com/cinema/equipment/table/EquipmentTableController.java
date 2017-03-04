package com.cinema.equipment.table;

import com.cinema.equipment.Equipment;
import com.cinema.equipment.Type;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import static com.cinema.equipment.SampleData.getLights;
import static com.cinema.equipment.SampleData.getSounds;
import static com.cinema.equipment.SampleData.getVideos;

/**
 * @author slyns
 * @version 3/4/17.
 */
public class EquipmentTableController implements EventHandler<ActionEvent>, Initializable {
  private int number = 1;
  private ObservableList<EquipmentTableModel> items = FXCollections.observableList(Stream.of(getLights(), getVideos(), getSounds())
                                                                                      .flatMap(List::stream)
                                                                                      .peek(e -> e.setId(String.valueOf(number++)))
                                                                                      .map(EquipmentTableModel::new)
                                                                                      .collect(Collectors.toList()));

  @FXML
  private ChoiceBox<Type> typeChoice;
  @FXML
  private TextField descriptionField;

  @FXML
  private TableView<EquipmentTableModel> records;

  @Override
  public void handle(ActionEvent event) {
    Equipment newItem = new Equipment(typeChoice.getValue(), descriptionField.getText());
    newItem.setId(String.valueOf(number++));
    items.add(new EquipmentTableModel(newItem));
    typeChoice.setValue(Type.VIDEO);
    descriptionField.clear();
  }

  public ObservableList<EquipmentTableModel> getItems() {
    return items;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    records.setItems(items);
  }
}
