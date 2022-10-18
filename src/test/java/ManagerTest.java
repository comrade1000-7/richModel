import org.junit.jupiter.api.*;

public class ManagerTest {
    private Repository repo = new Repository();
    private Manager manager = new Manager(repo);

    Product product = new Smartphone(1, "iPhone", 100_000, "Apple");
    Product product1 = new Book(2, "Crime", 200,"Tolstoy");
    Product product2 = new Book(3, "Sherlock", 300,"Conan Doyle");
    Product product3 = new Book(4, "Harry Potter", 1000,"Rolling");
    Product product4 = new Book(5, "James Bond", 700,"Fleming");
    Product product5 = new Book(6, "Sherlock", 2000,"Conan Doyle Junior");

    @BeforeEach
    public void setup() {
        repo.saveProduct(product);
        repo.saveProduct(product1);
        repo.saveProduct(product2);
        repo.saveProduct(product3);
        repo.saveProduct(product4);
    }

    @Test
    public void shouldAddProduct () {
        Product[] expected = {product, product1, product2, product3, product4, product5};

        manager.addProduct(product5);
        Product[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByOneProduct () {
        Product[] expected = {product4};
        Product[] actual = manager.searchBy("James Bond");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFewProduct () {
        Product[] expected = {product2, product5};
        manager.addProduct(product5);
        Product[] actual = manager.searchBy("Sherlock");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNoProduct () {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Sherlock: Resurrected");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProductMethod () {
        Product[] expected = {product};
        Product[] actual = manager.searchBy("iPhone");

        Assertions.assertArrayEquals(expected, actual);
    }
}
