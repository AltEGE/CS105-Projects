public class Hat extends Abstract_Clothes{
    private String bodyPart = "Head Body";
    private String model = "Hat";
    private int ID = 2;

    public Hat (double price,String color, int ID) {
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