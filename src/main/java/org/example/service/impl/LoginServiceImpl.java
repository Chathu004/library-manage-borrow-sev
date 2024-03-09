package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Login;
import org.example.entity.LoginEntity;
import org.example.repository.LoginRepository;
import org.example.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
   final LoginRepository repository;
   final ModelMapper mapper;
    @Override
    public void insertLoginData(Login login) {
        repository.save(mapper.map(login, LoginEntity.class));

    }
}
