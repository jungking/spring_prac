package com.example.prac.Dto;

import com.example.prac.Domain.PostEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommentForm {
    private Long id;
    private String title;
    private String content;
    private String userid;
    private PostEntity postEntity;

    @Builder
    public CommentForm(Long id, String title, String content, String userid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userid = userid;
    }

}