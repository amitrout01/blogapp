package com.myblog.blogapp.payload;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CommentDto {

    private  long id;

    private String body;

    private String email;

    private String name;

}
