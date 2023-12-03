package com.example.cms.model.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cameras")

public class Camera {

    @Id
    private long cid;

    @NotEmpty
    private String resolution;

    @NotEmpty
    private String f_number;

    @NotEmpty
    private String optical_zoom;

    @NotEmpty
    private String digital_zoom;



    @OneToMany(mappedBy = "camera")
    private List<Product> products;


    public Camera(long cid, String resolution, String f_number, String optical_zoom, String digital_zoom){
        this.cid = cid;
        this.resolution = resolution;
        this.f_number = f_number;
        this.optical_zoom = optical_zoom;
        this.digital_zoom = digital_zoom;

    }

}
