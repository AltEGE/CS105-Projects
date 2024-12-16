public class Pant extends Abstract_Clothes{
    private String bodyPart = "Lower Body";
    private String model = "Jean";
    private int ID = 3;

    public Pant(double price , String color , int ID)
    {
        super(price, color, ID);
    }
    public String getModel(){
        return model;

    }
    public void setModel(String model){
        this.model = model;

    }
    @Override
    public void getInfo () {
        System.out.println("Your item is " + color + " " + model + "\n"
                + "Model price is " + price + "\n");

    }
}
