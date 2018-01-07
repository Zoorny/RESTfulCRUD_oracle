package com.netcracker;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyerMapper implements RowMapper<Buyer> {

    public Buyer mapRow(ResultSet resultSet, int i) throws SQLException {

        Buyer buyer = new Buyer();
        buyer.setId(resultSet.getInt("id"));
        buyer.setName(resultSet.getString("name"));
        buyer.setLocation(resultSet.getString("location"));
        buyer.setDiscount(resultSet.getInt("discount"));
        return buyer;

    }
}
