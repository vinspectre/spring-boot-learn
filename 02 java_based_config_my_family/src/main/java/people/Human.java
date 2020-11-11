package people;

public abstract class Human implements IHuman {
    String name;
    Boolean isMale;

    public void setName(String name) {
        this.name = name;
    }

    public void setIsMale(Boolean male) {
        isMale = male;
    }

    public String getName() {
        return name;
    }

    public Boolean isMale() {
        return isMale;
    }

}
