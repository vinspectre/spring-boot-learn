package com.example.jdbctemplatetest.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class NamedParameterJdbcCarDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private CarRowMapper carRowMapper = new CarRowMapper();

    @Autowired
    public NamedParameterJdbcCarDao(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Car> getCarsByBrand(String brand) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("brand", brand);
        return jdbcOperations.query("SELECT * FROM CARS WHERE BRAND = :brand", params, carRowMapper);
    }

    private static class CarRowMapper implements RowMapper<Car> {
        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("ID");
            String brand = resultSet.getString("BRAND");
            String model = resultSet.getString("MODEL");
            return new Car(id, brand, model);
        }
    }
}
