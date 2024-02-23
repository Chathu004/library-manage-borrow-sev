package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Borrower;
import org.example.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
