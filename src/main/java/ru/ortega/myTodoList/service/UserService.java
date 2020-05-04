package ru.ortega.myTodoList.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ortega.myTodoList.persist.entity.User;
import ru.ortega.myTodoList.persist.repo.UserRepository;
import ru.ortega.myTodoList.reprs.UserRepr;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRepr userRepr){
        User user = new User();
        user.setUsername(userRepr.getUsername());
        user.setPassword(userRepr.getPassword());
        userRepository.save(user);
    }
}
