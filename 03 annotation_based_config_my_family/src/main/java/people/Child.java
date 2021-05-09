package people;

public abstract class Child extends Human {
    IHuman father;
    IHuman mather;
    IHuman brSis;

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
