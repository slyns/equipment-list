package com.cinema.equipment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.beans.Observable;
import javafx.util.Callback;

/**
 * @author slyns
 * @version 3/1/17.
 */
public class SampleData {

  public static List<Equipment> getVideos() {
    return Stream.of(new Equipment(Type.VIDEO, "Камера"), new Equipment(Type.VIDEO, "Об’єктив"), new Equipment(Type.VIDEO, "Батарея"))
               .collect(Collectors.toList());
  }

  public static List<Equipment> getLights() {
    return Stream.of(new Equipment(Type.LIGHT, "Кіловатник"), new Equipment(Type.LIGHT, "Прожектор 150 Вт")).collect(Collectors.toList());
  }

  public static List<Equipment> getSounds() {
    return Stream.of(new Equipment(Type.SOUND, "Мікрофон"), new Equipment(Type.SOUND, "Вітрозахист")).collect(Collectors.toList());
  }
}
