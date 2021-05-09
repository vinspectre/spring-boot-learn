package com.example.propertiestest.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertiesGetter {
    private String version;
    private String name;
    private int number;
    private boolean work;

    @Autowired
    public PropertiesGetter(Appl appl, NewProp newProp) {
        this.version = appl.getVersion();
        this.name = newProp.getName();
        this.number = newProp.getNumber();
        this.work = newProp.isWork();
    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isWork() {
        return work;
    }
}
