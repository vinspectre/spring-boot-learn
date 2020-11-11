package people;

public class Child extends Human {
    private IHuman father;
    private IHuman mather;
    private IHuman brSis;

    public void setFather(IHuman father) {
        this.father = father;
    }

    public void setMather(IHuman mather) {
        this.mather = mather;
    }

    public void setBrSis(IHuman brSis) {
        this.brSis = brSis;
    }

    @Override
    public void tellAboutFamily() {
        String brSisType = brSis.isMale() ? "brother" : "sister";
        System.out.println("Hi! I'm " + super.name);
        System.out.println("My father is " + father.getName() + " and mather is " + mather.getName());
        System.out.println("Also i have a " + brSisType + " " + brSis.getName());
        System.out.println("______________");
        System.out.println();
    }
}
