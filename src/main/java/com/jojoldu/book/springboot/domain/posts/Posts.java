package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 주요 어노테이션을 클래스에 가깝게
@Getter // Lombok -> 코드 단순화 (모든 필드의 Getter 메소드 자동생성)
@NoArgsConstructor // Lombok -> 코드 단순화 (기본 생성자 자동 추가)
@Entity // JPA -> 테이블과 링크될 클래스 => SalsesManager.java -> salse_manager (table)
public class Posts extends BaseTimeEntity{ // 실제 DB의 테이블과 매칭될 클래스, Entity Class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙, auto_increment해준다
    private Long id;

    // 테이블의 칼럼, 굳이 선언 안해도 클래스 필드는 모두 column
    // 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용(타입 변경 or vatchar length 늘리기
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // Entity class 에는 Setter 메소드를 만들지 않는다
    // 클래스 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없어, 차후 기능 변경 시 정말 복잡해진다
    // 대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야 한다

    // Setter가 없는데 어떻게 값을 채워 DB에 insert 할까?
    // 생성자를 통해 최종값 채운 후 DB에 삽입
    // 값변경이 필요할 경우 해당 이벤트에 맞는 public method를 호출하여 변경
    // => 책에서는 @Builder 생성자나 빌더나 생성 시점에 값을 채워준다 -> 생성자의 경우 지금 채워야 할 필드가 무엇인지 명확히 지정할 수 없다

    @Builder // builder 패턴: 패당 클래스의 빌더 패턴 클래스를 생성-> 생성자 상단 시 해당 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
