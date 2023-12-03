package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "accounts")
public class Account {
    @Id
    private long uid;

    @NotEmpty
    private String username;
    @NotEmpty
    private String email;

    @ManyToOne
    @JoinColumn(name = "blacklistId")
    @JsonBackReference
    //https://stackoverflow.com/questions/61094824/getting-infinite-recursion-with-jpa-hibernate-by-onetomany-and-manytoone
    private Blacklist blacklist;

    @ManyToMany
    @JoinTable(
            name = "product_liked",
            joinColumns = @JoinColumn(name = "uid"),
            inverseJoinColumns = @JoinColumn(name = "pid"))
    Set<Product> likedProducts;
    //https://www.baeldung.com/jpa-many-to-many

    public Account(long uid, String username,String email ){
        this.uid = uid;
        this.username = username;
        this.email = email;
    }


}
