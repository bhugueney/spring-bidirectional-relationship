package org.bernard.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@JsonIdentityInfo(
        scope = Item.class,
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)// ERROR if LAZY with @JsonIdentityInfo
    @JoinColumn(name = "app_user")
    private AppUser appUser;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId().equals(item.getId()) &&
                getName().equals(item.getName()) &&
                getAppUser().equals(item.getAppUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAppUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

}
