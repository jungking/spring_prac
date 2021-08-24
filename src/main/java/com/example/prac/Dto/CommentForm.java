package com.example.prac.Dto;

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

    @Builder
    public CommentForm(Long id, String title, String content, String userid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userid = userid;
    }

}