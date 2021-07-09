package org.bernard.service;

import org.bernard.model.AppUser;
import org.bernard.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    AppUserRepository appUserRepository;

    public Page<AppUser> findAll(Pageable pageable){
        return appUserRepository.findAll(pageable);
    }
}
