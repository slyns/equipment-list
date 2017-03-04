package com.cinema.equipment.table;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author slyns
 * @version 3/1/17.
 */
public class TableDemo extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.setTitle(this.getClass().getSimpleName());
    FXMLLoader fxml = new FXMLLoader(getClass().getResource("/ui.fxml"));
    Scene scene = new Scene(fxml.load());
    stage.setTitle("Прога для Саші");
    stage.setWidth(600);
    stage.setHeight(500);

    stage.setScene(scene);
    stage.show();
  }

}
