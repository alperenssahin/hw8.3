package penguinSupermarket;

public final class PenguinSupermarket {
    private Checkout[] checkouts;

    public PenguinSupermarket(int x) {
        if(x<=0){
            ExceptionUtil.unsupportedOperation("Funds must be greater than 0");
        }else{
            this.checkouts = new Checkout[x];
            for(int i = 0; i<x; i++){
                this.checkouts[i] = new Checkout();
            }
        }
    }

    public Checkout getCheckoutWithSmallestQueue(){
        Checkout small = this.checkouts[0];
        for (Checkout checkout : this.checkouts) {
            if (checkout.queueLength() < small.queueLength()) {
                small = checkout;
            }
        }
        return small;
    }
    public void closeCheckout(int index){
        try{
            Checkout tmp = this.checkouts[index];
            Checkout[] tmpArr = new Checkout[this.checkouts.length-1];
            int counter =0;
            for(Checkout c : this.checkouts){
                if(c != tmp){
                    tmpArr[counter] = c;
                    counter++;
                }
            }
            setCheckouts(tmpArr);
            LinkedQueue<PenguinCustomer> pcq = tmp.getCustomerQueue();
            PenguinCustomer pc = pcq.dequeue();
            while (pc != null){
                pc.goToCheckout(this);
                pc = pcq.dequeue();
            }
        }catch(Exception ex) {
            ExceptionUtil.unsupportedOperation("Checkout is not exist");
        }
    }
    public void serveCustumer(){
        for(Checkout c : this.checkouts){
            c.serveNextCustomer();
        }
    }
    public Checkout[] getCheckouts() {
        return checkouts;
    }

    public void setCheckouts(Checkout[] checkouts) {
        this.checkouts = checkouts;
    }
}
