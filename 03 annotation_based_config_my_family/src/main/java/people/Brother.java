package people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class Brother extends Child {

    public Brother(@Value("${child.brother.name}") String name) {
        this.name = name;
        this.isMale = true;
    }

    @Autowired
    public void setFather(Father father) {
        this.father = father;
    }

    @Autowired
    public void setMather(Mather mather) {
        this.mather = mather;
    }

    @Autowired
    public void setBrSis(@Qualifier("sister") Child brSis) {
        this.brSis = brSis;
    }

}
