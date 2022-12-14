import org.junit.jupiter.api.*;

public class RepositoryTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Product product = new Smartphone(1, "iPhone", 100_000, "Apple");
    Product product1 = new Book(2, "Crime", 200,"Tolstoy");
    Product product2 = new Book(3, "Sherlock", 300,"Conan Doyle");
    Product product3 = new Book(4, "Harry Potter", 1000,"Rolling");

    @BeforeEach
    public void setup() {
        repo.saveProduct(product);
        repo.saveProduct(product1);
        repo.saveProduct(product2);
    }

    @Test
    public void shouldSaveProduct() {
        Product[] expected = {product, product1, product2, product3};
        repo.saveProduct(product3);
        Product[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAll() {
        Product[] expected = {product, product1, product2};
        Product[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveProduct() {
        Product[] expected = {product, product2};
        repo.removeProduct(2);
        Product[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
