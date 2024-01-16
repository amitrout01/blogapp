package com.blogapi.service;

import java.util.List;

import com.blogapi.payLoad.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto);

	PostDto getPostById(long id);

	List<PostDto> getAllPosts();

	PostDto updatePost(PostDto postDto, long id);

	void deletePost(long id);

}
