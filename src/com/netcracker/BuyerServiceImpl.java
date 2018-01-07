package com.netcracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    //private static List<Buyer> buyerList = null;
    @Autowired
    private BuyerDAO buyerDAO;

    public List<Buyer> getAll() {
        return buyerDAO.findAll();
    }

    public Buyer getById(int id) {
        return buyerDAO.findById(id);
    }

    public Buyer add(Buyer buyer) {
        buyerDAO.add(buyer);
        return buyer;
    }

    public boolean delete(int id) {
        buyerDAO.delete(id);
        return true;
    }

    public boolean deleteAll() {
        buyerDAO.deleteAll();
        return true;
    }
}
