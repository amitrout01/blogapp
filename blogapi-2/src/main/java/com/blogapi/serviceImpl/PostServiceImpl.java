package com.blogapi.serviceImpl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapi.entity.Post;
import com.blogapi.exception.ResourceNotFoundException;
import com.blogapi.payLoad.PostDto;
import com.blogapi.repository.PostRepository;
import com.blogapi.service.PostService;
@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepo;

	@Override
	public PostDto createPost(PostDto postDto) {
	  Post post = new Post();
	  //post.setId(postDto.getId());
	  post.setTitle(postDto.getTitle());
	  post.setDescription(postDto.getDescription());
	  post.setContent(postDto.getContent());
	  
	  Post savedPost = postRepo.save(post);
	  
	  PostDto dto = new PostDto();
	  dto.setId(savedPost.getId());
	  dto.setTitle(savedPost.getTitle());
	  dto.setDescription(savedPost.getDescription());
	  dto.setContent(savedPost.getContent());
	  
	  
		return dto;
	}

	@Override
	public PostDto getPostById(long id) {
		
	    Post post = postRepo.findById(id).orElseThrow(
	     ()-> new ResourceNotFoundException(id)
	    		);
	    PostDto dto = new PostDto();
	    dto.setId(post.getId());
		  dto.setTitle(post.getTitle());
		  dto.setDescription(post.getDescription());
		  dto.setContent(post.getContent());
		  return dto;
		
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = postRepo.findAll();
		List<PostDto> dtos = posts.stream().map(post->mapToDTO(post)).collect(Collectors.toList()
				);
		return dtos;
		
	}
	//Convert Entity to DTO
	private PostDto mapToDTO(Post post) {
		PostDto dto = new PostDto();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setDescription(post.getDescription());
		dto.setContent(post.getContent());
		return dto;
	}
	//Convert DTO into Entity
	private Post mapToEntity(PostDto postDto) {
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		return post;
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, long id) {
		
		Post post = postRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException(id)
				);
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		Post updatedPost = postRepo.save(post);
		PostDto dto = mapToDTO(updatedPost);
		return dto;
	}

	@Override
	public void deletePost(long id) {
		Post post = postRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException(id)
				);
		postRepo.delete(post);
		
	}

}
