package com.example.prac.Dto;

import com.example.prac.Domain.PostEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostForm {
    private Long id;
    private String title;
    private String content;
    private String userid;

    public PostEntity toEntity(){
        PostEntity postEntity = PostEntity.builder()
                .id(id)
                .title(title)
                .content(content)
                .userid(userid)
                .build();
        return postEntity;
    }

    @Builder
    public void postForm(Long id, String title, String content, String userid) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userid = userid;
    }

}
