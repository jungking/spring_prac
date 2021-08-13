package com.example.prac.Repository;

import com.example.prac.Domain.Post_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post_Entity,Long> {
}
