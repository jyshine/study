package com.shine.sample.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fid",referencedColumnName = "id")
    List<Comment> comments = new ArrayList<>();

    public Post() { }

    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
