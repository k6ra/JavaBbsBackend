package com.javabbsbackend.domain.user;

import com.javabbsbackend.domain.base.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserService implements IService<UserModel> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> find(int id) {
        return userRepository.find(id);
    }

    @Override
    public void entry(UserModel user) {
        userRepository.entry(user);
    }

    @Override
    public void update(UserModel user) {
        userRepository.update(user);
    }

    @Override
    public void delete(UserModel user) {
        userRepository.delete(user);
    }
}
