package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션 적용할 위치 선택
@Retention(RetentionPolicy.RUNTIME) // 컴파일러가 어노테이션을 다루는 방법을 기술, 어느 시점까지 영향을 미치는지를 결정
public @interface LoginUser { // 어노테이션 클래스(커스텀 클래스) 로 지정, LoginUser 라는 이름을 가진 어노테이션이 생성된다
}
