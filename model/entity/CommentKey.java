package com.example.cms.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class CommentKey implements Serializable {

    @Column(name = "uid")
    Long uid;

    @Column(name = "pid")
    Long pid;

    @Override
    public int hashCode() {
        String concatString = String.valueOf(uid.hashCode()) +
                String.valueOf(pid.hashCode());
        return concatString.hashCode();
    }
    public CommentKey(){}

    public CommentKey(Long uid, Long pid){
        this.setUid(uid);
        this.setPid(pid);
    }
    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof CommentKey))
            return false;
        CommentKey other = (CommentKey) o;
        return uid.equals(other.uid) &&
                pid.equals(other.pid);
    }

}
