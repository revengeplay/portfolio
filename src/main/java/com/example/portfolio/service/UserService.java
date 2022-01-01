package com.example.portfolio.service;

import com.example.portfolio.domain.User;
import com.example.portfolio.dto.UserForm;
import com.example.portfolio.exception.DuplicateEmailException;
import com.example.portfolio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUpUser(UserForm userForm) throws Exception{
        validateDuplicateEmail(userForm.getEmail());    // 이메일 중복 체크
        userRepository.save(User.createUser(userForm));
    }

    private void validateDuplicateEmail(String email) throws Exception{
        if(userRepository.existsByEmail(email)){
            throw new DuplicateEmailException();
        }
    }

}
