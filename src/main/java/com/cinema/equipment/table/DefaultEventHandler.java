package com.cinema.equipment.table;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;

/**
 * @author slyns
 * @version 3/2/17.
 */
public class DefaultEventHandler implements EventHandler<TableColumn.CellEditEvent<EquipmentTableModel, String>> {
  BiConsumer<EquipmentTableModel, String> biConsumer;

  public DefaultEventHandler(BiConsumer<EquipmentTableModel, String> biConsumer) {
    this.biConsumer = biConsumer;
  }

  @Override
  public void handle(TableColumn.CellEditEvent<EquipmentTableModel, String> event) {
    biConsumer.accept(event.getTableView().getItems().get(event.getTablePosition().getRow()), event.getNewValue());
  }
}
