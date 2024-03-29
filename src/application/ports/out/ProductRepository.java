package application.ports.out;

import domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
  void save(Product product);
  Optional<Product> findById(Long id);
  List<Product> findAll();
}
