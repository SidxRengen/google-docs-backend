package com.siddharth.controller;

import com.siddharth.dto.DocTitleDTO;
import com.siddharth.dto.DocumentChangeDTO;
import com.siddharth.dto.DocumentDTO;
import com.siddharth.dto.UserDocDTO;
import com.siddharth.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docs")
public class DocController {

    @Autowired
    DocService docService;

    @PostMapping("/create")
    public DocumentDTO createDoc(@RequestBody DocTitleDTO title) {
        return docService.createDoc(title);
    }

    @DeleteMapping("/delete/{id}")
    public Long deleteDoc(@PathVariable Long id) {
        return docService.deleteDoc(id);
    }

    @PatchMapping("/rename/{id}")
    public String updateDocTitle(@PathVariable Long id, @RequestBody DocTitleDTO docTitleDTO) {
        return docService.updateDocTitle(id, docTitleDTO);
    }

    @PatchMapping("/users/add/{id}")
    public UserDocDTO addUser(@PathVariable Long id, @RequestBody UserDocDTO userDoc) {
        return docService.addUser(id, userDoc);
    }

    @GetMapping("/users/shared/{id}")
    public List<UserDocDTO> getSharedUsers(@PathVariable Long id) {
        return docService.getSharedUsers(id);
    }

    @DeleteMapping("/users/remove/{id}")
    public String removeUser(@PathVariable Long id, @RequestBody UserDocDTO userDoc) {
        return docService.removeUser(id, userDoc);
    }

    @PatchMapping("users/permission/{id}")
    public String updatePermission(@PathVariable Long id, @RequestBody UserDocDTO userDoc) {
        return docService.updatePermission(id, userDoc);
    }

    @GetMapping("/all")
    public List<DocumentDTO> getAllDocs() {
        return docService.getAllDocs();
    }

    @GetMapping("/changes/{id}")
    public List<DocumentChangeDTO> getDocChanges(@PathVariable Long id) {
        return docService.getDocChanges(id);
    }

    @GetMapping("/{id}")
    public DocumentDTO getDoc(@PathVariable Long id) {
        return docService.getDoc(id);
    }

}