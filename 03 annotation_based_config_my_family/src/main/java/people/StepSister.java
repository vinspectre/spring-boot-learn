package people;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class StepSister extends Child {
    public StepSister(@Value("${child.stepsister.name}") String name) {
        this.name = name;
        this.isMale = false;
    }
}
