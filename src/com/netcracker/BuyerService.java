package com.netcracker;

import java.util.List;

public interface BuyerService {

    List<Buyer> getAll();

    Buyer getById(int id);

    Buyer add(Buyer buyer);

    boolean delete(int id);

    boolean deleteAll();
}
