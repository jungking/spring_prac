package com.example.prac.Repository;

import com.example.prac.Domain.CommentEntity;
import com.example.prac.Domain.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findCommentsByPostEntity(PostEntity postEntity);

    void deleteByID(Long commentID);
}
