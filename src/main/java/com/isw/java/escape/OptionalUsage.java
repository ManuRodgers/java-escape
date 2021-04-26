package com.isw.java.escape;

import java.util.Optional;

@SuppressWarnings("all")
public class OptionalUsage {
  public static class User {
    private String name;

    public String getName() {
      return name;
    }
  }

  private static void isUserEqualNull() {

    User user = null;
    Optional<User> optionalUser = Optional.ofNullable(user);
    optionalUser.ifPresent(
        user1 -> {
          System.out.println("User is not null");
        });
  }

  private static User anonymous() {
    return new User();
  }
// Optional is a
  public static void main(String[] args) {
    //    isUserEqualNull();
    User user = null;
    Optional<User> optionalUser = Optional.ofNullable(user);
    optionalUser.orElse(new User());
    //    prefer method.
    optionalUser.orElseGet(OptionalUsage::anonymous);

    optionalUser.orElseThrow(RuntimeException::new);

    optionalUser.ifPresent(
        user1 -> {
          System.out.println(user1.getName());
        });
    optionalUser.map(User::getName).orElse("Manu");
    optionalUser.map(User::getName).map(name -> name.length()).orElse(0);
  }
}
