package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    //인증된 사용자 정보를 저장하는 클래스
    //User class 내에 세션 정보를 가질 수 없는 이유
    //User class가 Session을 저장하려는 경우, User 클래스에 직렬화를 하지 않았기 때문에 오류가 발생한다
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}
