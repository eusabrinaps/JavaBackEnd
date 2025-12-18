import java.sql.*;
import java.util.Objects;
import java.util.Optional;

public class Product {
    private final String sku;
    private String name;
    private int quantity;
    private double price;

    public Product(String sku, String name, int quantity, double price) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    //Create INSERT INTO TABELA (x, y, z) VALUES (a, b, c);
    public static void save(Product product){
        String sql = "INSERT INTO products(code, name, quantity, price) VALUES (?, ?, ?, ?)";

        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:dataBase.sqlite");
            final PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, product.getSku());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getQuantity());
            statement.setDouble(4, product.getPrice());
            statement.executeUpdate();
            System.out.println("Salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Select SELECT * FROM TABELA WHERE code = ?;
    public static Optional<Product> select(String sku){
        String sql = "SELECT * FROM products WHERE code = ?";
        try(final Connection connection = DriverManager.getConnection("jdbc:sqlite:dataBase.sqlite");
            final PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, sku);
            final ResultSet rs = statement.executeQuery(); // retorno de dados
            if (rs.next())
                return Optional.of(new Product(rs.getString("code"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //Update UPDATE tabela SET name = ?, quantity = ?, price = ? WHERE code = ?;
    public static void update(Product product){
        String sql = "UPDATE products SET name = ?, quantity = ?, price = ? WHERE code = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:dataBase.sqlite");
            final PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, product.getName());
            statement.setInt(2, product.getQuantity());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getSku());
            statement.executeUpdate();
            System.out.println("Atualizado com sucesso!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Delete
    public static void delete(String sku) {
        String sql = "DELETE FROM products WHERE code = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:dataBase.sqlite");
            final PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, sku);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sku);
    }

    @Override
    public String toString() {
        return "Product{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public double getTotal(){return price*quantity;}
}
