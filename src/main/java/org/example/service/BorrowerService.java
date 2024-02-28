package org.example.service;

import org.apache.catalina.User;
import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;

import java.util.List;

public interface BorrowerService {
    void addBorrower(Borrower borrower);
    List<BorrowerEntity> getBorrower();
    boolean deleteBorrower(Long id);
    Borrower getBorrowerId(Long id);
    Borrower findByUserName(String userName);
    Boolean isExistUserName(String userName);

}
