//: enumerated/menu/Course.java
package com.company.enumerater.menu;

import com.company.enumerater.Enums;

public enum Course {
  APPETIZER(Food.Appetizer.class),
  MAINCOURSE(Food.MainCourse.class),
  DESSERT(Food.Dessert.class),
  COFFEE(Food.Coffee.class);
  private Food[] values;
  Course(Class<? extends Food> foodClass) {
    values = foodClass.getEnumConstants();
  }
  public Food randomSelection() {
    return Enums.random(values);
  }
} ///:~
