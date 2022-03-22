package com.example.postservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
  @Id
  private String id;
  private String post;
  private String postedBy;
  private Date createdAt;
  private Date updatedAt;




}
