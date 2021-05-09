package people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class Sister extends Child {

    public Sister(@Value("${child.sister.name}") String name) {
        this.name = name;
        this.isMale = false;
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
    public void setBrSis(@Qualifier("brother") Child brSis) {
        this.brSis = brSis;
    }
}
