package penguinSupermarket;

public class TestSuperMarket
{
    public static void main(String[] args) {
        PenguinSupermarket pm = new PenguinSupermarket(2);

        PenguinCustomer pc1 = new PenguinCustomer("Ali",1000);
        PenguinCustomer pc2 = new PenguinCustomer("Veli",1000);
        PenguinCustomer pc3 = new PenguinCustomer("Mehmet",1000);
        PenguinCustomer pc4 = new PenguinCustomer("Osman",1000);
        PenguinCustomer pc5 = new PenguinCustomer("Recai",1000);

        FishyProduct fp1= new FishyProduct("somon",50);
        FishyProduct fp2 = new FishyProduct("cipura",20);
        FishyProduct fp3 = new FishyProduct("levrek",30);

        pc1.addProductToBasket(fp1);
        pc1.addProductToBasket(fp1);
        pc1.addProductToBasket(fp1);
        pc1.addProductToBasket(fp1);

        pc2.addProductToBasket(fp3);
        pc2.addProductToBasket(fp2);

        pc3.addProductToBasket(fp2);
        pc3.addProductToBasket(fp3);

        pc4.addProductToBasket(fp2);

        pc5.addProductToBasket(fp2);

        pc1.goToCheckout(pm);
        pc2.goToCheckout(pm);
        pc3.goToCheckout(pm);
        pc4.goToCheckout(pm);
        pc5.goToCheckout(pm);

        pm.serveCustomers();
        pm.closeCheckout(0);
        System.out.println("/////////////////////");
        System.out.println("pc1: " +pc1.getMoney());
        System.out.println("pc2: "+ pc2.getMoney());
        System.out.println("pc3: " +pc3.getMoney());
        System.out.println("pc4: "+ pc4.getMoney());
        System.out.println("pc5: "+ pc5.getMoney());

        pm.serveCustomers();
        System.out.println("/////////////////////");
        System.out.println("pc1: " +pc1.getMoney());
        System.out.println("pc2: "+ pc2.getMoney());
        System.out.println("pc3: " +pc3.getMoney());
        System.out.println("pc4: "+ pc4.getMoney());
        System.out.println("pc5: "+ pc5.getMoney());
        pm.serveCustomers();
        System.out.println("/////////////////////");
        System.out.println("pc1: " +pc1.getMoney());
        System.out.println("pc2: "+ pc2.getMoney());
        System.out.println("pc3: " +pc3.getMoney());
        System.out.println("pc4: "+ pc4.getMoney());
        System.out.println("pc5: "+ pc5.getMoney());
        pm.serveCustomers();
        System.out.println("/////////////////////");
        System.out.println("pc1: " +pc1.getMoney());
        System.out.println("pc2: "+ pc2.getMoney());
        System.out.println("pc3: " +pc3.getMoney());
        System.out.println("pc4: "+ pc4.getMoney());
        System.out.println("pc5: "+ pc5.getMoney());
    }
}
