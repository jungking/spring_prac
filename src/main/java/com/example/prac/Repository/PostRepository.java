package com.example.prac.Repository;

import com.example.prac.Domain.PostEntity;
import com.example.prac.Dto.PostForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
