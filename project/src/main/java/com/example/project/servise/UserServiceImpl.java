package com.example.project.servise;

import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean signIn(String login, String password) {
        Optional<User> userCandidate = userRepository.findByLogin(login); // достаем из бд юзера по логину с помощью репозиоория
        if(userCandidate.isPresent()) { // есть ли у нас в бд бзер с эти логином
            if(userCandidate.get().getPassword().equals(password)){ // совпадают ли пароли
                return true;
            }
            return false;
        }
        return false;
    }

}
