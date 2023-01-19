package company;

import java.util.ArrayList;

public class Category {
    private String name;
    private int catergoryid;
    private ArrayList<Product> products;
    public Category(String name,int catergoryid){
        this.name=name;
        this.catergoryid=catergoryid;
        products=new ArrayList<>();
    }
    public void addproduct(Product w){
        products.add(w);
    }

    public String getName() {
        return name;
    }

    public int getCatergoryid() {
        return catergoryid;
    }
    public void removeproduct(int productid){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductid()==productid){
                products.remove(i);
            }
        }
    }
    public Product getproduct(int productid){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductid()==productid){
                return products.get(i);
            }
        }
        return null;
    }
    public int getproductquant(int productid){
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductid()==productid){
                return products.get(i).getQuantity();
            }
        }
        return 0;
    }
    public void getcatinfo(){
        System.out.println("this is the catgeory "+this.name);
        System.out.println("category id "+this.catergoryid);
        for (int i=0;i<this.products.size();i++){
            this.products.get(i).getallinfo();

        }

    }
}
