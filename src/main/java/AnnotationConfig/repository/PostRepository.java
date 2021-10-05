package AnnotationConfig.repository;

import org.springframework.stereotype.Repository;
import AnnotationConfig.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public final class PostRepository {
  private final List<Post> list = new ArrayList<>();
  private int counterByListId = 1;

  public List<Post> all() {
    List<Post> listWithoutRemoved = new ArrayList<>();
    for(Post e: list){
      if(!e.isRemoved())listWithoutRemoved.add(e);
    }
    return listWithoutRemoved;
  }

  public final Optional<Post> getById(long id) {
    for(Post e: list){
      if(e.getId() == id && !e.isRemoved()) {
        return Optional.of(e);
      }
    }
    return Optional.empty();
  }

  public final Optional<Post> save(Post post) {
    if(post.getId() == 0){
      post.setId(counterByListId);
      list.add(post);
      counterByListId++;
    }else{
      for(int i = 0; i < list.size(); i++){
        if(list.get(i).getId() == post.getId() && !list.get(i).isRemoved()){
          list.set(i, post);
          break;
        }
      }
    }
    return Optional.empty();
  }

  public final void removeById(long id) {
    for (int i = 0; i < list.size(); i++) {
      if(list.get(i).getId() == id){
        list.get(i).remove();
        break;
      }
    }
  }
}
