import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import people.Child;
import people.Father;
import people.Mather;

@Configuration
@ComponentScan("people")
@PropertySource("classpath:family.properties")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Main.class);
        ctx.refresh();

        Father father = ctx.getBean("father", Father.class);
        Mather mather = ctx.getBean("mather", Mather.class);
        Child sister = ctx.getBean("sister", Child.class);
        Child brother = ctx.getBean("brother", Child.class);
        father.tellAboutFamily();
        mather.tellAboutFamily();
        brother.tellAboutFamily();
        sister.tellAboutFamily();
    }
}
