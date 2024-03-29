package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Borrower;
import org.example.dto.Login;
import org.example.entity.BorrowerEntity;
import org.example.service.BorrowerService;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrower")
@RequiredArgsConstructor
@CrossOrigin
public class BorrowerController {

    final BorrowerService service;
    final LoginService loginService;
    @PostMapping("/add")
    public void addBorrower(@RequestBody Borrower borrower){
        service.addBorrower(borrower);
        loginService.insertLoginData(new Login(borrower.getEmail(),borrower.getPassword()));
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
    @GetMapping("/search-by-id/{id}")
    public Borrower getBorrowerId(@PathVariable Long id){
        return service.getBorrowerId(id);
    }
    @GetMapping("/search-by-name/{userName}")
    public Borrower findByUserName(@PathVariable String userName){
        return service.findByUserName(userName);
    }

    @GetMapping("/is-exist-userName/{userName}")
    public Boolean isExistUserName(@PathVariable String userName){
       return service.isExistUserName(userName);
    }



}
