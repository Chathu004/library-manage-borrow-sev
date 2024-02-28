package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Borrower;
import org.example.entity.BorrowerEntity;
import org.example.repository.BorrowerRepository;
import org.example.service.BorrowerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BorrowerServiceImpl implements BorrowerService {

    final BorrowerRepository repository;

    final ModelMapper mapper;
//    @Bean
//    public void setUp(){
//        this.mapper =  new ModelMapper();
//    }
    @Override
    public void addBorrower(Borrower borrower) {
        BorrowerEntity entity = mapper.map(borrower,BorrowerEntity.class);
        repository.save(entity);
    }

    @Override
    public List<BorrowerEntity> getBorrower() {
        return (List<BorrowerEntity>) repository.findAll();
    }

    @Override
    public Borrower getBorrowerId(Long id) {
        Optional<BorrowerEntity> byId = repository.findById(id);
        return mapper.map(byId, Borrower.class);
    }

    @Override
    public Borrower findByUserName(String userName) {
        return mapper.map(repository.findByUserName(userName),Borrower.class);
    }

    @Override
    public Boolean isExistUserName(String userName) {
       return repository.existsByUserName(userName);
    }

    @Override
    public boolean deleteBorrower(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return  true;
        }else{
            return false;
        }
    }
}
