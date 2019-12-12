package penguinSupermarket;

public final class PenguinCustomer {
    private final String name;
    private int availableMoney;
    private StackConnector<FishyProduct> products;

    public PenguinCustomer(String name, int availableMoney) {
        if (!name.equals("")) {
            this.name = name;
        } else {
            ExceptionUtil.illegalArgument("name attribute can not be null");
            this.name = "";
        }
        if (availableMoney >= 0) {
            this.availableMoney = availableMoney;
        } else {
            ExceptionUtil.illegalArgument("availableMoney attribute can not be less than 0");
            this.availableMoney = availableMoney;
        }
        this.products = new StackConnector<>(null);
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return availableMoney;
    }

    public StackConnector<FishyProduct> getProducts() {
        return products;
    }

    public void addProductToBasket(FishyProduct product) {
        this.products.push(product);
    }

    public QueueConnector<FishyProduct> placeAllProductsOnBand(QueueConnector<FishyProduct> queue) {
        FishyProduct tmp = this.products.pop();
        while (tmp != null) {
            queue.enqueue(tmp);
            tmp = this.products.pop();
        }
        return queue;
    }

    public void takeAllProductsFromBand(QueueConnector<FishyProduct> queue) {
        FishyProduct tmp = queue.dequeue();
        while (tmp != null) {
            this.products.push(tmp);
            tmp = queue.dequeue();
        }
    }

    public void pay(int amount) {
        if (this.availableMoney >= amount) {
            this.availableMoney -= amount;
        } else {
            ExceptionUtil.unsupportedOperation("Amount is greater than available money!(penguins can not have debts).");
        }
    }

    public void goToCheckout(PenguinSupermarket pm) {
        Checkout smallest = pm.getCheckoutWithSmallestQueue();
        smallest.getQueue().enqueue(this);
    }
}
