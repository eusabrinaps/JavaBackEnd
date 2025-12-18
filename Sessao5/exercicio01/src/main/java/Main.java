import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Product product = new Product("PC001", "Computador DELL", 1000, 1_933);
//        Product product1 = new Product("PC002", "Computador SAMSUNG", 1300, 2_933);
//        Product product2 = new Product("PC003", "Computador XING", 1800, 3_933);
//        Product product3 = new Product("PC004", "Computador LABUBU", 200, 1_953);
//        Product.save(product);
//        Product.save(product1);
//        Product.save(product2);
//        Product.save(product3);

//        Product.delete("PC004");
        Product.select("PC001").ifPresentOrElse(System.out::println, () -> {
            System.out.println("not found!");
        });
    }
}
