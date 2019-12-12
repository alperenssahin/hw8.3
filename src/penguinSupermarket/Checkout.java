package penguinSupermarket;

public final class Checkout {
    private LinkedQueue<PenguinCustomer> customerQueue;
    private LinkedQueue<FishyProduct> bandBeforeCashier;
    private LinkedQueue<FishyProduct> bandAfterCashier;

    public Checkout() {
        customerQueue = new LinkedQueue<>(null);
        bandBeforeCashier = new LinkedQueue<>(null);
        bandAfterCashier = new LinkedQueue<>(null);
    }
    public void serveNextCustomer(){
        PenguinCustomer current = customerQueue.dequeue();
        int amount = 0;
        if(current != null){
            this.bandBeforeCashier = current.placeAllProductOnBand(this.bandBeforeCashier);
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
        if(this.customerQueue == null){
            return 0;
        }else{
            return this.customerQueue.size();
        }
    }
    public LinkedQueue<PenguinCustomer> getCustomerQueue() {
        return customerQueue;
    }

    public LinkedQueue<FishyProduct> getBandBeforeCashier() {
        return bandBeforeCashier;
    }

    public LinkedQueue<FishyProduct> getBandAfterCashier() {
        return bandAfterCashier;
    }
}
