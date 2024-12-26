package src.Clothes;

public class Glasses extends Abstract_Clothes {

    public Glasses(double price, String color, int ID){
        super(price, color, ID);
        this.bodyPart = "Head Body";
        this.model = "Glasses";

    }
    public String getModel(){
        return model;
    }
    public void setModel(){this.model = model;}
}
