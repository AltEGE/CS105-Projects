package Clothes;

public class Skirt extends Abstract_Clothes {
    public Skirt (double price,String color, int ID){
        super(price,color, ID);
        this.bodyPart = "Lower Body";
        this.model = "Skirt";
    }
    public String getModel(){return model;}
    public void setModel(String model){this.model = model;}

}
