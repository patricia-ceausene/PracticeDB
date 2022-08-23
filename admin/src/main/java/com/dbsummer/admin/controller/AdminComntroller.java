package com.dbsummer.admin.controller;

import com.dbsummer.admin.model.Admin;
import com.dbsummer.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminComntroller {

    @Autowired
    AdminService adminService;

    @PostMapping("/users")
    @ResponseBody
    public Admin add(@RequestBody Admin admin) {
        return adminService.add(admin);
    }
}
