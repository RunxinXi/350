package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "storages")
public class Storage {

    @Id
    private Long sid;

    @NotNull
    private String store;

    @NotNull
    private int price;

    @ManyToOne
    @MapsId("pid")
    @JoinColumn(name = "pid")
    @JsonIgnoreProperties({"storages","cameras","specs","products"})
    private Product product;

    public Storage(){}

    public Storage(long sid, String storage, int price, Product product){
        this.sid = sid;
        this.store = storage;
        this.price = price;
        this.product = product;
    }

}
