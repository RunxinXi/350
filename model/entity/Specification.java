package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "specs")
public class Specification {
    @Id
    long specid;

    @NotEmpty
    String processor;

    @NotEmpty
    String memory;

    @NotEmpty
    String display;

    @NotEmpty
    String battery;

    //@OneToOne
    //@MapsId("pid")
    //@JoinColumn(name = "pid")
    //@JsonIgnoreProperties({"specs"})
    //private Product product;

public Specification(long specid, String processor, String memory, String display, String battery){
    this.specid = specid;
    this.processor = processor;
    this.memory = memory;
    this.display = display;
    this.battery = battery;
}


}
