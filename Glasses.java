public class Glasses extends Abstract_Clothes{
    private String bodyPart = "Head Body";
    private String model = "Glasses";

    public Glasses(double price, String color){
        super(price, color);


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
