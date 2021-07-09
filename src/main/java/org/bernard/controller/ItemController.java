package org.bernard.controller;

import org.bernard.model.Item;
import org.bernard.service.ItemService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springdoc.core.converters.models.PageableAsQueryParam;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET)
    @PageableAsQueryParam
    public Page<Item> findAll(//@Parameter(hidden = true)
                              @PageableDefault(page = 0, size = 20,
                                      sort = "id", direction = Sort.Direction.DESC)
                                      Pageable pageable) {
        return itemService.findAll(pageable);
    }

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public Item create() {
        return itemService.create();
    }
}
