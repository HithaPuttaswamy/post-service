package com.example.postservice.controller;

import com.example.postservice.model.Post;
import com.example.postservice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
  @Autowired
  private PostService postService;
  @GetMapping
  public ResponseEntity<List<Post>> getAllPosts() {
    List<Post> postData = postService.getAllPosts();
    return new ResponseEntity<>(postData, HttpStatus.OK);
  }
  @PostMapping
  public ResponseEntity<String> addComment(@RequestBody Post post) {
    String postData = postService.addPost(post);
    return new ResponseEntity<>(postData, HttpStatus.CREATED);
  }

  @GetMapping("/{postId}")
  public ResponseEntity<Post> getPostById(@PathVariable("postId") String postId) {
    Post postData = postService.getPostByPostId(postId);
    return new ResponseEntity<>(postData, HttpStatus.OK);
  }


  @PutMapping("/{postId}/comments/{commentId}")
  public ResponseEntity<Post> updateCommentByPostIdAndCommentId(@PathVariable("postId") String postId, @RequestBody Post post) {
    Post postData = postService.updatePostByPostId(postId, post);
    return new ResponseEntity<>(postData, HttpStatus.OK);
  }

  @DeleteMapping("/{postId}/comments/{commentId}")
  public ResponseEntity<String> deleteCommentByPostId(@PathVariable("postId") String postId) {
    String postData = postService.deletePostByPostId(postId);
    return new ResponseEntity<>(postData, HttpStatus.OK);
  }

}
