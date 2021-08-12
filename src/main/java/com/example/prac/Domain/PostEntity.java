package com.example.prac.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PostEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="post_title")
    private String title;

    @Column(name="post_content")
    private String content;

    @Column(name = "userid")
    private String userid;

    @Builder
    public PostEntity(String title, String content, String userid){
        this.title = title;
        this.content = content;
        this.userid = userid;
    }
}
