package iducs.springboot.a201712007.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    private int id;
    private String email;
    private String pw;
    private String name;
    private String phone;
    private String address;
}
