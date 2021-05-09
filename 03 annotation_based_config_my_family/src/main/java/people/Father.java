package people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Father extends Human {
    private IHuman spouse;
    private List<Child> children;

    public Father(@Value("${parent.father.name}") String name) {
        this.name = name;
        this.isMale = true;
    }

    @Autowired
    public void setSpouse(Mather spouse) {
        this.spouse = spouse;
    }

    @Autowired
    public void setChildren(List<Child> children) {
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
