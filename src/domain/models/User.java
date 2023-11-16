package domain.models;

public class User {
  private static int userCount = 1;
  private Long id;
  private String name;
  private String username;
  private String email;
  private String password;

  public User(String name, String email, String password) {
    this.id = (long) userCount;
    this.name = name;
    this.username = email;
    this.email = email;
    this.password = password;
    userCount++;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
