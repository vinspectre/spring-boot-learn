import org.springframework.context.support.ClassPathXmlApplicationContext;
import people.Child;
import people.Parent;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/family.xml");
        Parent father = (Parent) context.getBean("father");
        Parent mather = (Parent) context.getBean("mather");
        Child sister = (Child) context.getBean("sister");
        Child brother = (Child) context.getBean("brother");
        father.tellAboutFamily();
        mather.tellAboutFamily();
        brother.tellAboutFamily();
        sister.tellAboutFamily();
    }

}
