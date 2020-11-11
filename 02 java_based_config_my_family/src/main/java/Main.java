import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import people.Child;
import people.Parent;

@Configuration
@ComponentScan("people")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Main.class);
        ctx.refresh();

        Parent father = ctx.getBean("father",Parent.class);
        Parent mather = ctx.getBean("mather",Parent.class);
        Child sister = ctx.getBean("sister", Child.class);
        Child brother = ctx.getBean("brother", Child.class);
//        father.tellAboutFamily();
        mather.tellAboutFamily();
//        brother.tellAboutFamily();
//        sister.tellAboutFamily();
    }
}
