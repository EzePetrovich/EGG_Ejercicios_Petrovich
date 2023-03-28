
package entity;

public class Product {
    private String name;
    private Integer price;
    public Product() {}
    public Product(String name, Integer price) {this.name = name; this.price = price;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Integer getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}
    @Override
    public String toString() {return "[Producto: " + name + "; Precio: $" + price + "]";}
}
