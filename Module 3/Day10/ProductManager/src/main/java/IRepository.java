import java.util.List;

public interface IRepository {
    List<Product> displayList();
    Product findbyID(int id);
    void update (Product product);
    void create (Product product);
    void delete(Product product);

}
