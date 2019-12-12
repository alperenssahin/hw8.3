package penguinSupermarket;

public final class Checkout {
    private QueueConnector<PenguinCustomer> queue;
    private QueueConnector<FishyProduct> bandBeforeCashier;
    private QueueConnector<FishyProduct> bandAfterCashier;

    public Checkout() {
    	queue = new QueueConnector<>(null);
        bandBeforeCashier = new QueueConnector<>(null);
        bandAfterCashier = new QueueConnector<>(null);
    }
    public void serveNextCustomer(){
        PenguinCustomer current = queue.dequeue();
        int amount = 0;
        if(current != null){
            this.bandBeforeCashier = current.placeAllProductsOnBand(this.bandBeforeCashier);
            FishyProduct tmp = this.bandBeforeCashier.dequeue();
            while (tmp != null){
                amount += tmp.getPrice();
                this.bandAfterCashier.enqueue(tmp);
                tmp = this.bandBeforeCashier.dequeue();
            }
            current.takeAllProductsFromBand(this.bandAfterCashier);
            current.pay(amount);
        }
    }
    public int queueLength(){
        if(this.queue == null){
            return 0;
        }else{
            return this.queue.size();
        }
    }
    public QueueConnector<PenguinCustomer> getQueue() {
        return queue;
    }

    public QueueConnector<FishyProduct> getBandBeforeCashier() {
        return bandBeforeCashier;
    }

    public QueueConnector<FishyProduct> getBandAfterCashier() {
        return bandAfterCashier;
    }
}
