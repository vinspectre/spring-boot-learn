package com.example.propertiestest;

import com.example.propertiestest.components.PropertiesGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private PropertiesGetter propertiesGetter;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void displayAllBeans() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : allBeanNames) {
			System.out.println(beanName);
		}
	}

	public void displayAllProperties() {
		System.out.println("\nDisplay all properties");
		System.out.println(propertiesGetter.getName());
		System.out.println(propertiesGetter.getNumber());
		System.out.println(propertiesGetter.getVersion());
		System.out.println(propertiesGetter.isWork());
	}

	@Override
	public void run(String... args) {
		displayAllBeans();
		displayAllProperties();
	}
}
