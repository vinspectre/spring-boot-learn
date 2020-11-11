package people;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:family.properties")
public class FamilyConfiguration {
    @Value("${parent.father.name}")
    private String fatherName;

    @Value("${parent.mather.name}")
    private String matherName;

    @Value("${child.brother.name}")
    private String brotherName;

    @Value("${child.sister.name}")
    private String sisterName;

    @Bean
    Parent father() {
        Parent f = new Parent();
        f.setName(fatherName);
        f.setIsMale(true);
//        f.setSpouse(mather());
//        List<IHuman> children = new ArrayList<>();
//        children.add(sister());
//        children.add(brother());
//        f.setChildren(children);
        return f;
    }

    @Bean
    Parent mather () {
        Parent f = new Parent();
        f.setName(matherName);
        f.setIsMale(false);
        f.setSpouse(father());
        List<IHuman> children = new ArrayList<>();
        children.add(sister());
        children.add(brother());
        f.setChildren(children);
        return f;
    }

    @Bean
    Child sister () {
        Child c = new Child();
        c.setName(sisterName);
        c.setIsMale(false);
        c.setFather(father());
//        c.setMather(mather());
//        c.setBrSis(brother());
        return c;
    }

    @Bean
    Child brother () {
        Child c = new Child();
        c.setName(brotherName);
        c.setIsMale(true);
        c.setFather(father());
//        c.setMather(mather());
//        c.setBrSis(sister());
        return c;
    }

}
