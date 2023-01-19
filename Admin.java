package company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Admin {
    private String name;
    private int rollno;
    private ArrayList<Category> Categories;
    public void enteras(String n,int r){
        if((n.equals("beff jezos") && r==24556) || (n.equals("Gill gates")&& r==20544)){
            this.name=n;
            this.rollno=r;
            System.out.println("welcome "+this.name);
            Categories=new ArrayList<>();
        }
    }
    public void addcategory(String name,int categoryid,String name2,float price,int productid,int quantity,String info1,String info2){
        Product P=new Product(name2,price,productid,quantity,info1,info2);
        Category C=new Category(name,categoryid);
        C.addproduct(P);
        Categories.add(C);
    }
    public void deleteCategory(String name,int categoryid){
        for(int i=0;i<Categories.size();i++){
            if((name==Categories.get(i).getName() && categoryid==Categories.get(i).getCatergoryid())){
                Categories.remove(i);
            }
        }
    }
    public void addproduct(String categoryname,int categoryid,String name,float price,int productid,int quantity,String info1,String info2){
        Product p=new Product(name,price,productid,quantity,info1,info2);
        for(int i=0;i<Categories.size();i++){
            if(categoryid==Categories.get(i).getCatergoryid()){
                Categories.get(i).addproduct(p);
                return;
            }
        }
        Category C=new Category(categoryname,categoryid);
        C.addproduct(p);
        Categories.add(C);
    }
    public void deleteproduct(String categoryname,int productid){
        for(int i=0;i<Categories.size();i++){
            if(categoryname==Categories.get(i).getName()){
                Categories.get(i).removeproduct(productid);
            }
        }
    }
    public ArrayList<Category> getcategories(){
        return Categories;
    }
    public void setdiscount(int categoryid,int productid,int dicountamount){
        for(int i=0;i<Categories.size();i++){
           if(categoryid==Categories.get(i).getCatergoryid()){
               Categories.get(i).getproduct(productid).setDiscount(dicountamount);
           }
        }

    }
    public void setgiveawaydeals(int categoryid1,int productid1,int categoryid2,int productsid2,int combinedprice){
        System.out.println("the combined price of these items is 75");

    }
    public void showavailabledeals(){
        System.out.println("here are the products available to us");
        for(int i=0;i<Categories.size();i++){
            Categories.get(i).getcatinfo();
        }
    }

}
