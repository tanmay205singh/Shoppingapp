package company;

public class Coupon {
    private int value;
    public Coupon(){
        this.value=(int)((Math.random()*(15-5))+5);
        System.out.println("congratulation you get a new coupon");
    }
    public int getvalue(){
        return value;
    }
}
