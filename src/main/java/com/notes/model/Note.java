package com.notes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Note {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Lob
  @Column(name="CONTENT", length=2048)
  @NotEmpty
  private String content;
  private Boolean done = false;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Boolean getDone() {
    return done;
  }
  public void setDone(Boolean done) {
    this.done = done;
  }
  
}
