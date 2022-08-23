package com.dbsummer.practice.service;

import com.dbsummer.practice.client.AdminFeignClient;
import com.dbsummer.practice.model.AdminModel;
import com.dbsummer.practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminFeignClient adminFeignClient;


    public AdminModel add(User user) {
        AdminModel adminModel = new AdminModel(user.getEmail(),user.getRole());
        return adminFeignClient.add(adminModel);
    }
}
