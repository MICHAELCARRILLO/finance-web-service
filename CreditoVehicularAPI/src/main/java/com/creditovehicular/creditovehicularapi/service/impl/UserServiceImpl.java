package com.creditovehicular.creditovehicularapi.service.impl;

import com.creditovehicular.creditovehicularapi.entities.User;
import com.creditovehicular.creditovehicularapi.repository.IUserRepository;
import com.creditovehicular.creditovehicularapi.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public User save(User user) throws Exception {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) throws Exception {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) throws Exception {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        return  userRepository.findUserByEmail(email);
    }
}
