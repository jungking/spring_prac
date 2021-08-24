package com.example.prac.Domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long Id;

    private String title;
    private String content;
    private String userid;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity postEntity;

    public void setPost(PostEntity postEntity){
        this.postEntity = postEntity;
    }
}
