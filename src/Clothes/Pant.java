package Clothes;

public class Pant extends Abstract_Clothes {
    public Pant(double price , String color , int ID){
        super(price, color, ID);
        this.bodyPart = "Lower Body";
        this.model = "Jean";
    }
    public String getModel(){return model;}
    public void setModel(String model){this.model = model;}

}
