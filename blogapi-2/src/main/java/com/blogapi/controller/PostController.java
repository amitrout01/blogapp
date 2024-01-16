package com.blogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapi.payLoad.PostDto;
import com.blogapi.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	//http://localhost:8080/api/post
    @PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
    	System.out.println(postDto);
		 PostDto responseDto = postService.createPost(postDto);
		return new ResponseEntity<PostDto>(responseDto,HttpStatus.CREATED);
	}
    
  //http://localhost:8080/api/post/2
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id){
    	PostDto postById = postService.getPostById(id);
    	return new ResponseEntity<PostDto>(postById,HttpStatus.OK);
    	
    }
    //http://localhost:8080/api/post
    @GetMapping
    public List<PostDto> getAllPosts(){
    	List<PostDto> allPosts = postService.getAllPosts();
    	return allPosts;
    }
  //http://localhost:8080/api/post/2
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable("id") long id){
    	PostDto updatePost = postService.updatePost(postDto,id);
    	return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") long id){
    	postService.deletePost(id);
    	 return new ResponseEntity<String>("Post is Deleted Successfully",HttpStatus.OK); 
    }
}
