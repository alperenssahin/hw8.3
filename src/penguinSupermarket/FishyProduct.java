package penguinSupermarket;

public final class FishyProduct {
    private final String name;
    private final int price;

    FishyProduct(String name, int price) {
        if(!name.equals("")){
            this.name = name;
        }else{
            ExceptionUtil.illegalArgument("name attribute can not be null");
            this.name = "";
        }
        if(price>0) {
            this.price = price;
        }else{
            ExceptionUtil.illegalArgument("price attribute can not be less than or equal to 0");
            this.price = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
