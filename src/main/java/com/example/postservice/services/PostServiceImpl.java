package com.example.postservice.services;

import com.example.postservice.model.Post;
import com.example.postservice.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepo postRepo;

  @Override
  public List<Post> getAllPosts() {
    return  postRepo.findAll();
  }

  @Override
  public String addPost(Post post) {
    Post postId = postRepo.findByPostId(post.getId());
    if (postId != null) {
      return "error from add post method";
    } else {
      postRepo.save(post);
     return "post added successfully";
    }
  }

  @Override
  public Post getPostByPostId(String postId) {
    return postRepo.findByPostId(postId);
  }

  @Override
  public Post updatePostByPostId(String postsId, Post post) {
    Optional<Post> postDetails = Optional.ofNullable(postRepo.findByPostId(postsId));
    if (postDetails.isPresent()) {
      Post postData = postDetails.get();
      postData.setPost(postData.getPost());
      postData.setPostedBy(postData.getPostedBy());
      return postData;
    } else {
      return null;
    }
  }

  @Override
  public String deletePostByPostId(String postsId) {
    Post post = postRepo.findByPostId(postsId);
    postRepo.delete(post);
    return "post deleted";
  }
}
