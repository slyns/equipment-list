package com.cinema.equipment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author slyns
 * @version 3/1/17.
 */
public class SampleData {

  public static List<Equipment> getVideos() {
    return Stream.of(new Equipment("Відео", "Камера"), new Equipment("Відео", "Об’єктив"), new Equipment("Відео", "Батарея"))
               .collect(Collectors.toList());
  }

  public static List<Equipment> getLights() {
    return Stream.of(new Equipment("Світло", "Кіловатник"), new Equipment("Світло", "Прожектор 150 Вт")).collect(Collectors.toList());
  }

  public static List<Equipment> getSounds() {
    return Stream.of(new Equipment("Звук", "Мікрофон"), new Equipment("Звук", "Вітрозахист")).collect(Collectors.toList());
  }

  public static List<Equipment> getAll() {
    return Stream.of(getLights(), getVideos(), getSounds())
               .flatMap(List::stream)
               .collect(Collectors.toList());
  }
}
