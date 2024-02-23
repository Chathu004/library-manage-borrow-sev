package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;
import org.example.repository.BorrowerRepository;
import org.example.service.BorrowerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BorrowerServiceImpl implements BorrowerService {
    @Autowired
    BorrowerRepository repository;
    ModelMapper mapper;
    @Bean
    public void setUp(){
        this.mapper =  new ModelMapper();
    }
    @Override
    public void addBorrower(Borrower borrower) {
        BorrowerEntity entity = mapper.map(borrower,BorrowerEntity.class);
        repository.save(entity);
    }
}
