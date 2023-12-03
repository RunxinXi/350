package com.example.cms.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    private long pid;

    @NotEmpty
    private String pname;

    @NotNull
    private int price;

    @ManyToOne
    @MapsId("cid")
    @JoinColumn(name = "cid")
    @JsonIgnoreProperties({"products"})
    private Camera camera;

    //@OneToOne(mappedBy = "product")
    //private Specification specification;

    @OneToOne
    @MapsId("specid")
    @JoinColumn(name = "specid")
    private Specification specification;


    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties({"cameras","specs","products"})
    private List<Storage> storages= new ArrayList<>();



    @NotNull
    private int total;
    @NotNull
    private int num;


    public Product(long pid, String pname, int price, Camera camera, Specification spec, int num,int total){
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.camera = camera;
        this.specification = spec;
        this.num = num;
        this.total = total;
    }

}
