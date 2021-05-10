package com.example.jdbctemplatetest.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateTestDao {

    private static class TestRowMapper implements RowMapper<Test> {
        @Override
        public Test mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("NAME");
            return new Test(id, name);
        }
    }

    @Autowired
    private JdbcOperations jdbcOperations;

//  public void save(Person person) {
//      String sql = "insert into Person (first_Name, Last_Name, Address) values (?, ?, ?)";
//      jdbcTemplate.update(sql, person.getFirstName(), person.getLastName(),
//              person.getAddress());
//  }

    public List<Test> loadAll() {
        ArrayList<Test> result = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcOperations.queryForList("select * from Test");
        maps.forEach(stringObjectMap -> {
            int id = (int) stringObjectMap.get("ID");
            String name = (String) stringObjectMap.get("NAME");
            Test test = new Test(id, name);
            result.add(test);
        });
        return result;
    }

    public List<Test> loadAllByRowMapper() {
        return jdbcOperations.query("select * from Test", new TestRowMapper());
    }

    public int insertInTest(Test test) {
        return jdbcOperations.update("insert into test (id, name) values (?, ?)", test.getId(), test.getName());
    }

    public int getMaxId() {
        return jdbcOperations.queryForObject("select max(id) from test", Integer.class);
    }

//  private Person toPerson(ResultSet resultSet) throws SQLException {
//      Person person = new Person();
//      person.setId(resultSet.getLong("ID"));
//      person.setFirstName(resultSet.getString("FIRST_NAME"));
//      person.setLastName(resultSet.getString("LAST_NAME"));
//      person.setAddress(resultSet.getString("ADDRESS"));
//      return person;
//  }
}