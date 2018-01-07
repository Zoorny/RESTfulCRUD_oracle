package com.netcracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuyerRESTService {

    @Autowired
    BuyerService buyerService;

    @GetMapping(value = "/buyer",produces ="application/json" )
    public ResponseEntity<List<Buyer>> getAllContacts(){

        List<Buyer> buyers = buyerService.getAll();

        if (buyers.isEmpty())
            return new ResponseEntity<List<Buyer>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Buyer>>(buyers, HttpStatus.OK);

    }

    @GetMapping(value = "/buyer/{id}")
    public ResponseEntity<Buyer> getContactById(@PathVariable("id") int id){
        Buyer buyer = buyerService.getById(id);

        if (buyer == null)
            return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Buyer>(buyer, HttpStatus.OK);

    }


    @PostMapping(value = "/buyer",consumes = "application/json")
    public ResponseEntity<Buyer> addNewContact(@RequestBody Buyer buyer){
        buyerService.add(buyer);
        return new ResponseEntity<Buyer>(buyer, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/buyer/{id}")
    public ResponseEntity<Buyer> deleteContact(@PathVariable("id") int id){
        boolean result = buyerService.delete(id);

        if (!result)
            return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Buyer>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping(value="/buyer")
    public ResponseEntity<Buyer> deleteAll(){
        boolean result = buyerService.deleteAll();

        if (!result)
            return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Buyer>(HttpStatus.NO_CONTENT);

    }
}
