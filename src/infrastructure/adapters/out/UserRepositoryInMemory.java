package infrastructure.adapters.out;

import application.ports.out.UserRepository;
import domain.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepositoryInMemory implements UserRepository {
  private List<User> users;
  public UserRepositoryInMemory(){
    users = new ArrayList<>();
  }
  @Override
  public void save(User user) {
    users.add(user);
  }

  @Override
  public Optional<User> findById(Long id) {
    return users.stream()
            .filter(u-> Objects.equals(u.getId(), id))
            .findFirst();
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return users.stream()
            .filter(u-> u.getUsername().equals(username))
            .findFirst();
  }

  @Override
  public List<User> findAll() {
    return users;
  }
}
