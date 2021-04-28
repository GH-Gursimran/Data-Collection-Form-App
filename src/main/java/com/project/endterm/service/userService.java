package com.project.endterm.service;


import com.project.endterm.model.user;
import com.project.endterm.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    @Autowired
    private userRepo userRepo;

    public List<user> getAllUserInfo(){
        return userRepo.getAllPosts();
    }

    public boolean addUser(user newuser){
        return userRepo.addNewUser(newuser);
    }
    //public void editUser(Integer userId) {userRepo.editUser(userId);};
    public void deleteUser(Integer userId) {userRepo.deleteUser(userId);};
    public void updatePost(user updateuser) {userRepo.updateUser(updateuser);
    }
}
