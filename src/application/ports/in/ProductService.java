package application.ports.in;

import domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
  void create(Product product);
  Optional<Product> getById(Long id);
  List<Product> getAll();
}
