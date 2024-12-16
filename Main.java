public class Main {
    public static void main(String[] args) {
        Hat hat = new Hat (35, "Red" , 2);
        hat.getInfo();

        Skirt skirt = new Skirt (80, "Pink", 4);
        skirt.getInfo();

        Pant pant =  new Pant (85, "Blue", 3);
        pant.getInfo();

        Tshirt tshirt = new Tshirt (75, "Yellow", 5);
        tshirt.getInfo();

        Glasses glasses = new Glasses(35,"Black" , 1);
        glasses.getInfo();

        Shoe shoe = new Shoe (100, "Green", 6);
        shoe.getInfo();

        Glove glove = new Glove (30, "Orange", 7);
        glove.getInfo();



    }

}