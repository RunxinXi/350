package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "comments")
public class Comment {

    @EmbeddedId
    CommentKey commentId;

    @ManyToOne
    @MapsId("uid")
    @JoinColumn(name = "uid")
    @JsonIgnoreProperties({"comments"})
    private Account account;

    @ManyToOne
    @MapsId("pid")
    @JoinColumn(name = "pid")
    @JsonIgnoreProperties({"comments"})
    private Product product;

    @NotNull
    private String detail;

    @NotNull
    private boolean Edited;





}
