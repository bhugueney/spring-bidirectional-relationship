package org.bernard.service;

import org.bernard.model.AppUser;
import org.bernard.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    @Autowired
    AppUserRepository appUserRepository;

    public List<AppUser> findAll(){
        return appUserRepository.findAll();
    }

    public Page<AppUser> findAll(Pageable pageable){
        return appUserRepository.findAll(pageable);
    }
}
