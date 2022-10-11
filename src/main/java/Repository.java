public class Repository {
    protected Product[] repo = new Product[0];

    public void saveProduct (Product product) {
        Product[] tmp = new Product[repo.length + 1];
        System.arraycopy(repo, 0, tmp, 0, repo.length);
        tmp[tmp.length - 1] = product;
        repo = tmp;
    }

    public Product[] getAll () {
        return repo;
    }

    public void removeProduct (int id) {
        int index = 0;
        Product[] tmp = new Product[repo.length - 1];
        for (Product product : repo) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }

        }
        repo = tmp;
    }
}
