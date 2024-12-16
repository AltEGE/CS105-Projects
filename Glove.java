public class Glove extends Abstract_Clothes{
    private String bodyPart = " Hand Part";
    private String model = "Glove";
    private int ID = 7;


    public Glove (double price,String color, int ID) {
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

