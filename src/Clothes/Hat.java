package Clothes;

public class Hat extends Abstract_Clothes {
    public Hat (double price,String color, int ID) {
        super(price, color, ID);
        this.bodyPart = "Head Body";
        this.model = "Hat";
    }
    public String getModel(){return model;}
    public void setModel(String model){this.model = model;}

}