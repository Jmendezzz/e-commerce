package domain.models;

public class Product {
  private static int productCount = 0;
  private Long id;
  private String name;
  private Double price;
  private Integer stock;
  private User owner;

  public Product(String name, Double price, Integer stock, User owner) {
    this.id = (long) productCount;
    this.name = name;
    this.price = price;
    this.stock = stock;
    this.owner = owner;
    productCount++;
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

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  @Override
  public String toString() {
    return
            "Id: " + id +
            "\n Nombre: " + name  +
            "\n Precio: " + price +
            "\n Stock: " + stock;
  }
}
