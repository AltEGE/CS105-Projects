package Clothes;

public class Glove extends Abstract_Clothes {
    public Glove (double price,String color, int ID) {
        super(price, color, ID);
        this.bodyPart = " Hand Part";
        this.model = "Glove";
    }

    public String getModel(){return model;}
    public void setModel(String model){this.model = model;}

}

