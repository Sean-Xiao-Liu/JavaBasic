package CoreJava;

public class Enum {

    // An enum is a special "class" that represents a group of constants (unchangeable variables,
    // like final variables).

    public static void main(String[] args) {
        Size small = Size.SMALL;
        Size medium = Size.MEDIUM;
        System.out.println(small.getLength());

        Pants pants = new Pants("black","obey",medium);
        System.out.println(pants.getSize().getLength());

    }
}

class Pants{
    String color;
    String brand;
    Size size;

    public Pants(String color, String brand, Size size) {
        this.color = color;
        this.brand = brand;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}

enum Size{
    SMALL(10),
    MEDIUM(20),
    LARGE(30);

    int length;

    Size(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}