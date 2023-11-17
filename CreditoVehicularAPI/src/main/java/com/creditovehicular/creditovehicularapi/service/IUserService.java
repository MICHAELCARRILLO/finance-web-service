package com.creditovehicular.creditovehicularapi.service;

import com.creditovehicular.creditovehicularapi.entities.User;

public interface IUserService extends CrudService<User>{
    public User findUserByEmailAndPassword(String email, String password) throws Exception;
    public User findUserByEmail(String email) throws Exception;
}
