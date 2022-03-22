package com.example.postservice.services;

import com.example.postservice.model.Post;

import java.util.List;

public interface PostService {
  List<Post> getAllPosts();
  String addPost(Post post);
  Post getPostByPostId(String postId);
  Post updatePostByPostId(String postsId, Post post);
  String deletePostByPostId(String postsId);
}
