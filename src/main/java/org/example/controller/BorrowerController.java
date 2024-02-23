package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;
import org.example.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/borrower")
@RequiredArgsConstructor
@CrossOrigin
public class BorrowerController {
    @Autowired
    BorrowerService service;
    @PostMapping("/add")
    public void addBorrower(@RequestBody Borrower borrower){
        service.addBorrower(borrower);

    }
    @GetMapping("/get")
    public Iterable<BorrowerEntity> getBorrower(){
        return service.getBorrower();
    }
    @DeleteMapping("/remove/{id}")
    public String deleteBorrower(@PathVariable Long id){
        service.deleteBorrower(id);
        return "delete borrower!";
    }



}
