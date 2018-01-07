package com.netcracker;

import java.util.List;

public interface BuyerDAO {

    Buyer findById(int id);
    List<Buyer> findAll();
    boolean add(Buyer buyer);
    void delete(int id);
    void deleteAll();

}
