public class Pant extends Abstract_Clothes{
    private String bodyPart = "Lower Body";
    private String model = "Jean";

    public Pant(double price , String color) {
        super(price, color);
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
