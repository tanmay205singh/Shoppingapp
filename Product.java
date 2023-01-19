package company;

public class Product {
    private String name;
    private int quantity;
    private float price;
    private int productid;
    private String info1;
    private String info2;
    private boolean isdiscounted;
    private int discount;
    public Product(String name,float price,int productid,int quantity,String info1,String info2){
        this.name=name;
        this.price=price;
        this.productid=productid;
        this.quantity=quantity;
        this.info1=info1;
        this.info2=info2;
        this.isdiscounted=false;
        this.discount=0;
    }

    public float getPrice() {
        return price;
    }
    public int getDiscount(){
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getProductid() {
        return productid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getInfo1() {
        return info1;
    }

    public String getInfo2() {
        return info2;
    }
    public boolean isIsdiscounted(){
        return isdiscounted;
    }
    public void getallinfo(){
        this.getName();
        this.getQuantity();
        this.getPrice();
        this.getProductid();
        this.getInfo1();
        this.getInfo2();
    }
}
