package com.itheima.domain;

import lombok.*;

//lombok

//@Setter
//@Getter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
@Data         //等于所有，但是不包含构造方法
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;

}
