public abstract class Abstract_Clothes {
    protected double price;
    protected String color;
    protected int ID;

  public Abstract_Clothes(double price,String color, int ID) {
      this.price = price;
      this.color = color;
      this.ID = ID;
  }
  public abstract void getInfo ();


  public double getPrice(){
      return price;
  }
  public void setPrice(double price){
      this.price = price;

  }
  public String color (){
      return color;

  }
  public void setColor (String color){
      this.color = color;
  }

}
