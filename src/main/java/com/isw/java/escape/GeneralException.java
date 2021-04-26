package com.isw.java.escape;

import com.google.common.base.Enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("all")
public class GeneralException {
  private static class User {
    private String name;

    public User() {}

    public User(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }

  private static class Manager extends User {}

  private static class Worker extends User {}

  private static final Map<String, StaffType> STRING_STAFF_TYPE_MAP =
      new HashMap<>(StaffType.values().length);

  static {
    for (StaffType value : StaffType.values()) {
      STRING_STAFF_TYPE_MAP.put(value.name(), value);
    }
  }

  private static void concurrentModificationException(ArrayList<User> users) {

    //    for (User user : users) {
    //      if (user.getName().equals("imooc")) {
    //        users.remove(user);
    //      }
    //    }
    // 不要循环遍历中做删除操作 用stream的过滤方法
    Iterator<User> userIterator = users.iterator();
    while (userIterator.hasNext()) {
      User user = userIterator.next();
      if (user.getName().equals("imooc")) {
        userIterator.remove();
      }
    }
  }

  private static StaffType findEnum(String type) {
    //     This will throw an IllegalArgumentException if the type is not included in the enum
    //    return StaffType.valueOf(type);
    //    First method to handle
    //    try {
    //      return StaffType.valueOf(type);
    //    } catch (IllegalArgumentException illegalArgumentException) {
    //      return null;
    //    }
    //    second method to handle with low performance
    //    for (StaffType value : StaffType.values()) {
    //      if (value.name().equals(type)) {
    //        return value;
    //      }
    //    }
    //    return null;
    //    third method to handle with high performance because only loop through the enum once
    //    return STRING_STAFF_TYPE_MAP.get(type);
    //    fourth method to handle with the google guava enum
    return Enums.getIfPresent(StaffType.class, type).orNull();
  }

  public static void main(String[] args) {
    //    1. concurrentModificationException
    //    ArrayList<User> users = new ArrayList<>(Arrays.asList(new User("Manu"), new
    // User("imooc")));
    //    System.out.println(users);
    //    concurrentModificationException(users);
    //    System.out.println(users);
    //    2. ClassCastException
    //    User user1 = new Manager();
    //    User user2 = new Worker();
    //    Manager manager1 = (Manager) user1;
    //    if (user2 instanceof Manager) {
    //      Manager manager2 = (Manager) user2;
    //    } else {
    //      System.out.println("user2 is not an instance of Manuger");
    //    }

    System.out.println(findEnum("RD"));
    System.out.println(findEnum("abc"));
  }
}
