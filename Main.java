package company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to FLIPZONE");
        System.out.println("1)Enter as Admin");
        System.out.println("2)Explore the Product Catalog");
        System.out.println("3) Show Available Deals");
        System.out.println("4)Enter as Customer");
        System.out.println("5)Exit the Application");
        Scanner sc= new Scanner(System.in);
        boolean b=false;
        while(!b){
            int x=sc.nextInt();
            if(x==1){
                b=true;
            }
            else if(x==2){
                System.out.println("sorry nothing to see at the moment");
            }
            else if(x==3){
                System.out.println("no deals available at the moment");
            }
            else if(x==4){
                System.out.println("sorry the shop isn't done yet");
            }
            else if (x == 5) {
                System.out.println("thanks for using the application");
            }
        }
        System.out.println("enter password");
        int password=sc.nextInt();
        sc.nextLine();
        Admin a=new Admin();
        System.out.println("enter your user name");
        String s=sc.nextLine();
        a.enteras(s,password);
        System.out.println("Please choose any of the following action");
        System.out.println("1) Add category");
        System.out.println("2) Delete category");
        System.out.println("3) Add Product");
        System.out.println("4) Delete Product");
        System.out.println("5) Set Discount on Product");
        System.out.println("6) Add giveaway deal");
        System.out.println("7) Back");
        System.out.println("enter the number of category you want to set ");
        int noofcategory=sc.nextInt();
        for(int i=0;i<noofcategory;i++){
            b=false;
            while(!b){
                int x=sc.nextInt();
                if(x==1){
                    System.out.println("you can now add the products");
                    b=true;
                }
                else{
                    System.out.println("rest action can't be performed at the moments due to no stock availability");
                }
            }
            System.out.println("enter the category name");
            sc.nextLine();
            String categoryname=sc.nextLine();
            System.out.println("enter category id");
            int categoryid=sc.nextInt();
            sc.nextLine();
            System.out.println("enter the product name");
            String productname=sc.nextLine();
            System.out.println("enter product price");
            float productprice=sc.nextFloat();
            System.out.println("enter product id");
            int productid=sc.nextInt();
            System.out.println("enter the quantity of product");
            int quantity=sc.nextInt();
            sc.nextLine();
            System.out.println("enter the product qualifications");
            String info1=sc.nextLine();
            System.out.println("enter the product features");
            String info2=sc.nextLine();
            a.addcategory(categoryname,categoryid,productname,productprice,productid,quantity,info1,info2);
            System.out.println("product added");
        }
        System.out.println("enter how many discount you want to give");
        int noofdiscount=sc.nextInt();
        for(int i=0;i<noofdiscount;i++){
            System.out.println("now time to set discount");
            System.out.println("enter category which would have the product to be dicounted ");
            int categoryid=sc.nextInt();
            System.out.println("enter the product id");
            int productid=sc.nextInt();
            System.out.println("enter the amount of discount you want to set");
            int discount=sc.nextInt();
            a.setdiscount(categoryid,productid,discount);
        }
        System.out.println("proceed for forward");
        System.out.println("Welcome to FLIPZONE");
        System.out.println("1)Enter as Admin");
        System.out.println("2)Explore the Product Catalog");
        System.out.println("3) Show Available Deals");
        System.out.println("4)Enter as Customer");
        System.out.println("5)Exit the Application");
        int x=sc.nextInt();
        if(x==4){
            for(int i=0;i<3;i++){
                Customer m=new Customer(a);
                System.out.println("1)Sign up");
                System.out.println("2)Log in");
                System.out.println("3)Back");
                x=sc.nextInt();
                if (x==1){
                    sc.nextLine();
                    System.out.println("dear customer enter your name");
                    String customername=sc.nextLine();
                    System.out.println("enter your age");
                    int age=sc.nextInt();
                    System.out.println("enter your phone number ");
                    int phonenumber=sc.nextInt();
                    sc.nextLine();
                    System.out.println("give email id");
                    String emailid=sc.nextLine();
                    System.out.println("enter password");
                    String passwordemail=sc.nextLine();
                    m.Signup(customername,age,phonenumber,emailid,passwordemail);
                    m.login(customername,age,phonenumber,emailid,passwordemail);
                    System.out.println("1)browse products");
                    System.out.println("2)browse deals");
                    System.out.println("3)add a product to cart");
                    System.out.println("4)add products in deal to cart");
                    System.out.println("5)view coupons");
                    System.out.println("6)check account balance");
                    System.out.println("7)view cart");
                    System.out.println("8)empty cart");
                    System.out.println("9)checkout cart");
                    System.out.println("10)upgrade customer status");
                    System.out.println("11)Add amount to wallet");
                    System.out.println("12)Back");
                    System.out.println("enter number of operation you want to perform");
                    int r=sc.nextInt();
                    for(int k=0;k<r;k++){
                        x=sc.nextInt();
                        if(x==12){
                            System.out.println("thanks for using FLIPZONE");
                            break;
                        }
                        switch (x){
                            case 10:
                                sc.nextLine();
                                String status=sc.next();
                                m.upgradestatus(status);
                                break;
                            case 11:
                                System.out.println("enter the amount to be added to wallet");
                                float amount=sc.nextFloat();
                                m.addamoutowallet(amount);
                                break;
                            case 6:
                                float accoundbalance=m.getWalletamount();
                                System.out.println("your account balance is currentle "+accoundbalance);
                                break;
                            case 1:
                                m.browseproducts(a);
                                break;
                            case 7:
                                m.viewcart();
                                break;
                            case 8:
                                m.clearcart();
                                break;
                            case 3:
                                System.out.println("eneter how many products you need");
                                int noofproducts=sc.nextInt();
                                for(int j=0;j<noofproducts;j++){
                                    System.out.println("enter the category id you want");
                                    int categoryid=sc.nextInt();
                                    System.out.println("enter the product id");
                                    int productid=sc.nextInt();
                                    System.out.println("enter the number of products of the same you need");
                                    int quantity=sc.nextInt();
                                    m.addtoCart(categoryid,productid,quantity);
                                }
                                System.out.println("ypu purchased tthe following things");
                                m.viewcart();
                                m.makepayment();
                                System.out.println("the amount to left in wallet");
                                System.out.println(m.getWalletamount());
                                break;
                            case 5:
                                try{
                                    Coupon cc=m.getC();
                                    System.out.println("you have a coupon of value "+cc.getvalue());
                                }
                                catch (Exception e){
                                    System.out.println(e);
                                }
                                break;
                            case 9:
                                m.makepayment();
                                System.out.println("thanks for visiting ");
                        }
                    }

                }
            }

        }
        if(x==2){
            a.showavailabledeals();
        }
        if(x==5){
            System.out.println("thanks for using the FLIPZONE");
        }

    }
}
