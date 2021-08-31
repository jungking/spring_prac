package com.example.prac.Dto;

import com.example.prac.Domain.CommentEntity;
import com.example.prac.Domain.PostEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommentForm {
    private String title;
    private String content;
    private String userid;
    private PostEntity postEntity;

    @Builder
    public CommentForm(String title, String content, String userid, PostEntity postEntity) {
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.postEntity = postEntity;
    }

    public CommentEntity toEntity() {
        CommentEntity commentEntity = CommentEntity.builder()
                .title(title)
                .content(content)
                .userid(userid)
                .postEntity(postEntity)
                .build();
        return commentEntity;
    }

}