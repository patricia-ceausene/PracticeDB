package com.dbsummer.practice.service;

import com.dbsummer.practice.client.JPlaceholderFeignClient;
import com.dbsummer.practice.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPlaceholderService {
    @Autowired
    JPlaceholderFeignClient jPlaceholderFeignClient;

    public List<Album> getAllAlbums() {
        return jPlaceholderFeignClient.getAlbums();
    }

    public Album postAlbum(Album album) {
        return jPlaceholderFeignClient.postAlbum(album);
    }

    public Album deleteAlbum(int id) {
        return jPlaceholderFeignClient.deleteAlbum(id);
    }
}
