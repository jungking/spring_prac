package com.example.prac.Domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="userid")
    private String userid;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity postEntity;

    @Builder
    public CommentEntity(Long id, String title, String content, String userid, PostEntity postEntity){
        this.id = id;
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.postEntity = postEntity;
    }

}
