package DesignPattern.HeadFirst.Factory;

public abstract class Pizza {
    private String name;
    private String sauce;

    abstract void bake();
    abstract void cut();
    abstract void box();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
}
