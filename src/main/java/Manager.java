public class Manager {
    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void addProduct (Product product) {
        repo.saveProduct(product);
    }

    public Product[] searchBy (String text) {
        Product[] result = new Product[0];

        for (Product product : repo.getAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    /*public boolean matches (Product product, String search) {
        return product.getName().contains(search);
    }*/
}
