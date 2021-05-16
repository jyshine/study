package com.shine;


import com.shine.sample.domain.entity.Comment;
import com.shine.sample.domain.entity.Post;
import com.shine.sample.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
//@EnableJpaAuditing
//@EnableJpaRepositories(basePackages = "study.datajpa.repository")
//jpa repository 위치를 잡아줘야한다. 안잡아 줄 경우 Application.class 위치 기준으로 하위 패키지로 스켄
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        Post post = new Post("one to many mapping using JPA and hibernate","discription !!");
        Comment comment1 = new Comment("Very useful");
        Comment comment2 = new Comment("informative");
        Comment comment3 = new Comment("Great post");

        post.getComments().add(comment1);
        post.getComments().add(comment2);
        post.getComments().add(comment3);

        this.postRepository.save(post);
    }
}
