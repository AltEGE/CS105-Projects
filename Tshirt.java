public class Tshirt extends Abstract_Clothes{
    private String bodyPart = "Upper Body";
    private String model = "Tshirt";
    private int ID = 5;

    public Tshirt( double price , String color, int ID) {
        super(price, color, ID);

    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model= model;

    }
    @Override
    public void getInfo(){
        System.out.println("Your item is " + color + " " + model + "\n"
                + "Model price is " + price + "\n");
    }
}
