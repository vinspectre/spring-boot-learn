package people;

import java.util.List;

public class Parent extends Human {
    private IHuman spouse;
    private List<IHuman> children;

    public void setSpouse(IHuman spouse) {
        this.spouse = spouse;
    }

    public void setChildren(List<IHuman> children) {
        this.children = children;
    }

    @Override
    public void tellAboutFamily() {
        String state = super.isMale ? "Father" : "Mather";
        String spState = super.isMale ? "wife" : "husband";
        System.out.println("Hi! I'm " + state + " " + super.name);
        System.out.println("I have " + spState + " " + spouse.getName());
        System.out.println("I have " + children.size() + " children:");
        children.forEach(ch -> {
            String chType = ch.isMale() ? "Son" : "Daughter";
            System.out.println("    "+chType + " " + ch.getName());
        });
        System.out.println("_______________");
        System.out.println();
    }
}
