package com.example.portfolio.domain;

import com.example.portfolio.dto.UserForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String userName;

    @Column(length = 50, nullable = false)
    private String password;

    public User(){} // JPA에서 빈 User 생성자를 필요로 함

    public User(UserForm userForm) { // 정적 팩토리 메소드
        this.email = userForm.getEmail();
        this.userName = userForm.getUserName();
        this.password = userForm.getPassword();
    }

    public static User createUser(UserForm userForm){
        return new User(userForm);
    }

}
