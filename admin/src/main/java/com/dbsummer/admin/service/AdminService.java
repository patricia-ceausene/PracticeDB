package com.dbsummer.admin.service;

import com.dbsummer.admin.model.Admin;
import com.dbsummer.admin.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;


    public Admin add(Admin admin) {
       return adminRepository.save(admin);
    }

}
