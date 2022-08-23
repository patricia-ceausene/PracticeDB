package com.dbsummer.practice.controller;

import com.dbsummer.practice.model.Album;
import com.dbsummer.practice.service.JPlaceholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JPlaceholderController {
    @Autowired
    JPlaceholderService jPlaceholderService;

    @GetMapping("/albums/get")
    public void listAlbums() {
        System.out.println(jPlaceholderService.getAllAlbums());
    }

    @GetMapping("/albums/post")
    public void postAlbum() {
        Album album = new Album(1,2,"post album");
        System.out.println(jPlaceholderService.postAlbum(album));
    }

    @GetMapping("/albums/delete")
    public void deleteAlbum() {
        System.out.println(jPlaceholderService.deleteAlbum(1));
    }
}
