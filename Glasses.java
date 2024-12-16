public class Glasses extends Abstract_Clothes{
    private String bodyPart = "Head Body";
    private String model = "Glasses";
    private int ID = 1;

    public Glasses(double price, String color, int ID){
        super(price, color, ID);


    }
    public String getModel(){
        return model;
    }
    public void setModel(){
        this.model = model;

    }
    public void getInfo(){
        System.out.println("Your item is " + color + " " + model + "\n"
                + "Model price is " + price + "\n");
    }

}
