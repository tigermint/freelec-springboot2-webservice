package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // DB Layer 접근자
    // Reposiory라고 부르며 interface로 생성
    // JpaRepository<Entity class, PK type>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성
    // 주의할 점 -> Entity 클래스, 기본 Entity Repository 는 함께 위치해야 한다

    //SpringDataJpa 에서 제공하지 않는 메소드
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}

