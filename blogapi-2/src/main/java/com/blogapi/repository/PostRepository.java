package com.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapi.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
