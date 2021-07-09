package org.bernard.controller;

import org.bernard.model.AppUser;
import org.bernard.model.Item;
import org.bernard.repository.AppUserRepository;
import org.bernard.service.AppUserService;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appusers")
public class AppUserController {
    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppUserService appUserService;


    @RequestMapping(method = RequestMethod.GET)
    @PageableAsQueryParam
    public Page<AppUser> findAll(//@Parameter(hidden = true)
                                 @PageableDefault(page = 0, size = 20,
                                      sort = "id", direction = Sort.Direction.DESC)
                                      Pageable pageable) {
        return appUserService.findAll(pageable);
    }

}
