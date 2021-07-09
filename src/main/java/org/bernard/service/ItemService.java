package org.bernard.service;

import org.bernard.model.AppUser;
import org.bernard.model.Item;
import org.bernard.repository.AppUserRepository;
import org.bernard.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AppUserRepository appUserRepository;

    public Item create(){
        AppUser fakeUser= new AppUser();
        fakeUser.setName("bernard");
        fakeUser= appUserRepository.save(fakeUser);
        Item fakeItem= new Item();
        fakeItem.setName("bike");
        fakeItem.setAppUser(fakeUser);
        fakeItem=itemRepository.save(fakeItem);
        return fakeItem;
    }
    public Page<Item> findAll(Pageable pageable){
        return itemRepository.findAll(pageable);
    }
}
