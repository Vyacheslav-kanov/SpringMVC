package AnnotationConfig.service;

import org.springframework.stereotype.Service;
import AnnotationConfig.exception.NotFoundException;
import AnnotationConfig.model.Post;
import AnnotationConfig.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
  private final PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public List<Post> all() {
    return repository.all();
  }

  public Post getById(long id) throws NotFoundException{
    return repository.getById(id).orElseThrow(NotFoundException::new);
  }

  public Post save(Post post) throws NotFoundException {
    return repository.save(post).orElseThrow(NotFoundException::new);
  }

  public void removeById(long id) {
    repository.removeById(id);
  }
}

