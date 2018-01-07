package com.netcracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BuyerDAOImpl implements BuyerDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Buyer findById(int id) {
        String sql = "select * from buyers where id = :id";
        Map<String, Object> namedParams = new HashMap<String, Object>();
        namedParams.put("id", id);
        return namedParameterJdbcTemplate.query(sql, namedParams, new BuyerMapper()).get(0);
    }

    public List<Buyer> findAll() {
        String sql = "select * from buyers";
        return namedParameterJdbcTemplate.query(sql, new BuyerMapper());
    }

    public boolean add(Buyer buyer) {
        String sql = "insert into buyers (id, name, location, discount) values (?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{buyer.getId(), buyer.getName(), buyer.getLocation(), buyer.getDiscount()});
        return true;

    }

    public void delete(int id) {
        String sql = "delete from buyers where id = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

    public void deleteAll() {
        String sql = "delete from buyers";
        jdbcTemplate.update(sql);
    }
}


