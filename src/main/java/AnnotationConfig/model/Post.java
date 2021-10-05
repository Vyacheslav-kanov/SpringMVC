package AnnotationConfig.model;

public class Post {
  private boolean removed;
  private long id;
  private String content;

  public Post() {
  }

  public Post(long id, String content) {
    this.id = id;
    this.content = content;
    removed = false;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void remove(){
    removed = true;
  }

  public boolean isRemoved() {
    return removed;
  }
}
