package AnnotationConfig.controller;

import AnnotationConfig.model.Post;
import AnnotationConfig.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  private final PostService service;

  public PostController(PostService service) {
    this.service = service;
  }

  @GetMapping
  public List<Post> all() {
    return service.all();
  }

  @GetMapping("/{id}")
  public Post getById(@PathVariable long id) {
    return service.getById(id);
  }

  @PostMapping
  public Post save(@PathVariable Post post) {
    return service.save(post);
  }

  @DeleteMapping("/{id}")
  public void removeById(long id) {
    service.removeById(id);
  }
}

