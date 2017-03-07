package com.cinema.equipment.table;

import com.cinema.equipment.db.DatabaseService;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author slyns
 * @version 3/1/17.
 */
public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    File dbDir = new File("db");
    if (!dbDir.exists() || !dbDir.isDirectory()) {
      dbDir.mkdir();
    }
    Connection c = DriverManager.getConnection("jdbc:hsqldb:file:db/equipment-list", "SA", "");
    stage.setTitle(this.getClass().getSimpleName());
    FXMLLoader fxml = new FXMLLoader(getClass().getResource("/ui.fxml"));
    fxml.setControllerFactory(new ControllerFactory(new DatabaseService(c)));
    Scene scene = new Scene(fxml.load());
    stage.setTitle("Прога для Саші");
    stage.setWidth(600);
    stage.setHeight(500);

    stage.setScene(scene);
    stage.show();
  }

}
