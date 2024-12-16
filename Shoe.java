public class Shoe extends Abstract_Clothes{
    private String bodyPart = "Feet Part";
    private String model = "Shoe";
    private int ID = 6;

    public Shoe(double price,String color, int ID) {
        super(price, color, ID);


    }

    public String getModel(){
        return model;

    }
    public void setModel(String model){
        this.model = model;

    }

    @Override
    public void getInfo(){
        System.out.println("Your item is " + color + " " + model + "\n"
                + "Model price is " + price + "\n");
    }
}
