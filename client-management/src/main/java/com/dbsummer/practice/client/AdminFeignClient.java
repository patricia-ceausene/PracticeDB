package com.dbsummer.practice.client;

import com.dbsummer.practice.model.AdminModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "adminFeignClient", url ="http://localhost:8080/")
public interface AdminFeignClient {

    @PostMapping("/users")
    public AdminModel add(@RequestBody AdminModel adminModel);


}
