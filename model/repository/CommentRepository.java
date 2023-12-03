package com.example.cms.model.repository;
import com.example.cms.model.entity.CommentKey;
import com.example.cms.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, CommentKey> {

    @Query(value = "select * from comments c "+
            "where c.account ==:uid",nativeQuery = true)
    List<Comment> searchUserComment(@Param("uid")Long uid);
}
