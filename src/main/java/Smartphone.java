public class Smartphone extends Product {
    protected String producer;

    public String getProducer() {
        return producer;
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    @Override
    public boolean matches (String search) {
        if (super.matches(search)) {
            return true;
        }
        return getProducer().contains(search);
    }
}
