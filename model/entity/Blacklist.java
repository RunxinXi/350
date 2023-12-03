package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "blacklists")
public class Blacklist {

    @Id
    private long blacklistId;

    @OneToMany(mappedBy = "blacklist")
    @JsonIgnoreProperties({"blacklists"})
    @JsonManagedReference
    private List<Account> accounts = new ArrayList<>();


    public Blacklist(long blacklistId){
        this.blacklistId = blacklistId;
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }

}
