package com.dbsummer.practice.client;

import com.dbsummer.practice.model.Album;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "JPlaceholderFeignCLient", url = "https://jsonplaceholder.typicode.com/")
public interface JPlaceholderFeignClient {

    @GetMapping("/albums")
    List<Album> getAlbums();

    @PostMapping("/albums")
    Album postAlbum(@RequestBody Album album);

    @DeleteMapping("/albums/{id}")
    Album deleteAlbum(@PathVariable int id);

}
