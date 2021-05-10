package com.example.jdbctemplatetest;

import com.example.jdbctemplatetest.components.Car;
import com.example.jdbctemplatetest.components.JdbcTemplateTestDao;
import com.example.jdbctemplatetest.components.NamedParameterJdbcCarDao;
import com.example.jdbctemplatetest.components.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JdbcTemplateTestApplication implements CommandLineRunner {
	@Autowired
	JdbcTemplateTestDao jdbcTemplateTestDao;
	@Autowired
	NamedParameterJdbcCarDao namedParameterJdbcCarDao;

	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateTestApplication.class, args);
	}


	@Override
	public void run(String... args) {
		System.out.println("\nTEST table operations:\n");
		List<Test> tests = jdbcTemplateTestDao.loadAll();
		System.out.println(tests);
		int maxId = jdbcTemplateTestDao.getMaxId();
		System.out.println("Max ID = " + maxId);
		int recordsOperated = jdbcTemplateTestDao.insertInTest(new Test(maxId + 1, "New Name"));
		System.out.println("Records operated: " + recordsOperated);
		tests = jdbcTemplateTestDao.loadAllByRowMapper();
		System.out.println(tests);
		maxId = jdbcTemplateTestDao.getMaxId();
		System.out.println("Max ID = " + maxId);
		System.out.println("\nCAR table operations:\n");
		List<Car> lada = namedParameterJdbcCarDao.getCarsByBrand("LADA");
		List<Car> kia = namedParameterJdbcCarDao.getCarsByBrand("KIA");
		System.out.println(lada);
		System.out.println(kia);
	}
}
