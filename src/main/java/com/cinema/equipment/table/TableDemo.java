package com.cinema.equipment.table;

import com.cinema.equipment.Equipment;
import com.cinema.equipment.Type;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static com.cinema.equipment.SampleData.getLights;
import static com.cinema.equipment.SampleData.getSounds;
import static com.cinema.equipment.SampleData.getVideos;

/**
 * @author slyns
 * @version 3/1/17.
 */
public class TableDemo extends Application {
  private final TableView<EquipmentTableModel> table = new TableView<>();
  private int number = 1;
  private ObservableList<EquipmentTableModel> list = FXCollections.observableList(Stream.of(getLights(), getVideos(), getSounds())
                                                                                              .flatMap(List::stream)
                                                                                              .peek(e -> e.setId(String.valueOf(number++)))
                                                                                              .map(EquipmentTableModel::new)
                                                                                              .collect(Collectors.toList()));
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle(this.getClass().getSimpleName());
    Scene scene = new Scene(new Group());
    stage.setTitle("Прога для Саші");
    stage.setWidth(600);
    stage.setHeight(500);

    final Label label = new Label("Список обладнання");
    label.setFont(new Font("Arial", 20));

    table.setEditable(true);

    TableColumn<EquipmentTableModel, String> numColumn = new TableColumn<>("Номер");
    numColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

    TableColumn<EquipmentTableModel, String> typeColumn = new TableColumn<>("Тип");
    typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
    typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    typeColumn.setOnEditCommit(new DefaultEventHandler(EquipmentTableModel::setType));

    TableColumn<EquipmentTableModel, String> descriptionColumn = new TableColumn<>("Опис");
    descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    descriptionColumn.setOnEditCommit(new DefaultEventHandler(EquipmentTableModel::setDescription));
    descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

    table.getColumns().addAll(numColumn, typeColumn, descriptionColumn);
    table.setItems(list);

    ChoiceBox<Type> typeChoice = new ChoiceBox<>(FXCollections.observableArrayList(Stream.of(Type.values()).collect(Collectors.toList())));

    final TextField descriptionField = new TextField();
    descriptionField.setMaxWidth(descriptionColumn.getPrefWidth());
    descriptionField.setPromptText("Опис");

    final Button addButton = new Button("Додати");
    addButton.setOnAction((ActionEvent e) -> {
      Equipment newItem = new Equipment(typeChoice.getValue(), descriptionField.getText());
      newItem.setId(String.valueOf(number++));
      list.add(new EquipmentTableModel(newItem));
      typeChoice.setValue(Type.VIDEO);
      descriptionField.clear();
    });

    final HBox hbox = new HBox();
    hbox.getChildren().addAll(typeChoice, descriptionField, addButton);
    hbox.setSpacing(3);

    final VBox vbox = new VBox();
    vbox.setPrefWidth(400);
    vbox.setSpacing(5);
    vbox.setPadding(new Insets(10, 0, 0, 10));
    vbox.getChildren().addAll(label, table, hbox);

    ((Group) scene.getRoot()).getChildren().addAll(vbox);

    stage.setScene(scene);
    stage.show();
  }

}
