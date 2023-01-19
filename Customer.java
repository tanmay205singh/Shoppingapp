package company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private int age;
    private int phonenumber;
    private String emailid;
    private String password;
    private String status;
    private ArrayList<Product> Cart;
    private ArrayList<Category> cartcat;
    private float Walletamount;
    private Coupon c;
    public Customer(Admin m){
        this.status="normal";
        this.Walletamount=1000;
        this.Cart=new ArrayList<>();
        this.cartcat=m.getcategories();
        this.c=null;

    }

    public void Signup(String name,int age,int phonenumber,String emailid,String password){
        this.name=name;
        this.age=age;
        this.phonenumber=phonenumber;
        this.emailid=emailid;
        this.password=password;

    }
    public boolean login(String name,int age,int phonenumber,String emailid,String password){
        if(this.name.equals(name) && this.age==age&& this.phonenumber==phonenumber&& this.emailid.equals(emailid)&& this.password==password){
            System.out.println("welcome "+this.name);
            return true;
        }
        else{
            System.out.println("invalid user");
            return false;
        }
    }
    public void upgradestatus(String status){
        if (status=="prime"){
            this.status="prime";
            this.Walletamount=this.Walletamount-200;

        }
        else if(status=="elite"){
            this.status="elite";
            this.Walletamount=this.Walletamount-300;
        }
    }
    public void addamoutowallet(float amount){
        this.Walletamount=this.Walletamount+amount;
    }

    public float getWalletamount() {
        return Walletamount;
    }
    public void addtoCart(int categoryid,int productid,int quantity){
        for (int i=0;i<cartcat.size();i++){
            if(cartcat.get(i).getCatergoryid()==categoryid){
                Product p= cartcat.get(i).getproduct(productid);
                int j=p.getQuantity();
                if(quantity<=p.getQuantity()){
                    p.setQuantity(quantity);
                    Cart.add(p);
                    System.out.println("added to cart successful");
                    j=j-quantity;
                    cartcat.get(i).getproduct(productid).setQuantity(j);

                }
                else{
                    System.out.println("out of stock please try again later");
                }

            }
        }
    }
    public void makepayment(){
        if(this.cartiempty()){
            System.out.println("you haven't purchased anything");
        }
        if (this.status=="normal"){
            float sum=0;
            for (int i=0;i<Cart.size();i++){
                sum= sum+ Cart.get(i).getQuantity()*Cart.get(i).getPrice();
                float deliver = 100 + (0.05f * sum);//calculating shipping charges
                sum=sum+deliver;
                System.out.println("the total money to be paid is "+sum);
                System.out.println("your order will arrive in 7 days");
                this.Walletamount=this.Walletamount-sum;
                return;
            }
        }
        else if (this.status=="prime"&& this.c==null){
            float sum=0;
            for(int i=0;i<Cart.size();i++){
                if(!Cart.get(i).isIsdiscounted()){
                    sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                    float discount= 0.05f*sum;
                    sum=sum-discount;
                }
                else{
                    if(Cart.get(i).getDiscount()>5){
                        sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                        float discount=(Cart.get(i).getDiscount()*0.01f)*sum;
                        sum=sum-discount;
                    }
                    else{
                        sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                        float discount= 0.05f*sum;
                        sum=sum-discount;
                    }
                }
            }
            float delivery= 100+(0.02f*sum);
            sum= sum+delivery;
            System.out.println("total money to be paid is "+sum);
            System.out.println("your product will arrive in 3 days");
            if(sum>5000){
                this.c=new Coupon();
            }
            this.Walletamount=this.Walletamount-sum;
            return;
        }
        else if(this.status=="prime"&& this.c!=null){
            if(c.getvalue()>5){
                float discount=c.getvalue()*0.01f;
                float sum=0;
                for(int i=0;i<Cart.size();i++){
                    sum=sum+ (Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                }
                discount=discount*sum;
                sum=sum-discount;
                sum=sum +100+ (0.02f*sum);//delivery charges
                System.out.println("total money to be paid is"+sum);
                System.out.println("your product will arrive 3 days");
                this.Walletamount=this.Walletamount-sum;
                return;
            }
            else{
                float sum=0;
                for(int i=0;i<Cart.size();i++){
                    if(!Cart.get(i).isIsdiscounted()){
                        sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                        float discount= 0.05f*sum;
                        sum=sum-discount;
                    }
                    else{
                        if(Cart.get(i).getDiscount()>5){
                            sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                            float discount=(Cart.get(i).getDiscount()*0.01f)*sum;
                            sum=sum-discount;
                        }
                        else{
                            sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                            float discount= 0.05f*sum;
                            sum=sum-discount;
                        }
                    }
                }
                float delivery= 100+(0.02f*sum);
                sum= sum+delivery;
                System.out.println("total money to be paid is "+sum);
                System.out.println("your product will arrive in 3 days");
                if(sum>5000){
                    this.c=new Coupon();
                }
                this.Walletamount=this.Walletamount-sum;
                return;
            }
        }
        else if(this.status=="elite" && this.c==null){
            float sum=0;
            for(int i=0;i<Cart.size();i++){
                if(!Cart.get(i).isIsdiscounted()){
                    sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                    float discount= 0.10f*sum;
                    sum=sum-discount;
                }
                else{
                    if(Cart.get(i).getDiscount()>10){
                        sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                        float discount=(Cart.get(i).getDiscount()*0.01f)*sum;
                        sum=sum-discount;
                    }
                    else{
                        sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                        float discount= 0.10f*sum;
                        sum=sum-discount;
                    }
                }
            }
            float delivery= 100;
            sum= sum+delivery;
            System.out.println("total money to be paid is "+sum);
            System.out.println("your product will arrive in 3 days");
            if(sum>5000){
                this.c=new Coupon();
            }
            this.Walletamount=this.Walletamount-sum;
            return;
        }
        else if(this.status=="elite"&& this.c!=null){
            if(c.getvalue()>10){
                float discount=c.getvalue()*0.01f;
                float sum=0;
                for(int i=0;i<Cart.size();i++){
                    sum=sum+ (Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                }
                discount=discount*sum;
                sum=sum-discount;
                sum=sum +100;//delivery charges
                System.out.println("total money to be paid is"+sum);
                System.out.println("your product will arrive 3 days");
                return;
            }
            else{
                float sum=0;
                for(int i=0;i<Cart.size();i++){
                    if(!Cart.get(i).isIsdiscounted()){
                        sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                        float discount= 0.10f*sum;
                        sum=sum-discount;
                    }
                    else{
                        if(Cart.get(i).getDiscount()>10){
                            sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                            float discount=(Cart.get(i).getDiscount()*0.01f)*sum;
                            sum=sum-discount;
                        }
                        else{
                            sum=sum +(Cart.get(i).getPrice()*Cart.get(i).getQuantity());
                            float discount= 0.10f*sum;
                            sum=sum-discount;
                        }
                    }
                }
                float delivery= 100;
                sum= sum+delivery;
                System.out.println("total money to be paid is "+sum);
                System.out.println("your product will arrive in 1 days");
                if(sum>5000){
                    this.c=new Coupon();
                }
                this.Walletamount=this.Walletamount-sum;
                return;
            }
        }


    }
    public void browseproducts(Admin admin){
        System.out.println("the following products available");
        for(int i=0;i<admin.getcategories().size();i++){
            admin.getcategories().get(i).getcatinfo();
        }
    }
    public void clearcart(){
        this.Cart=new ArrayList<>();
    }
    public void viewcart(){
        System.out.println("here is all the information ");
        for(int i=0;i<Cart.size();i++){
            Cart.get(i).getallinfo();
        }
    }

    public Coupon getC() {
        return c;
    }
    public boolean cartiempty(){
        return Cart.size()==0;
    }
}



