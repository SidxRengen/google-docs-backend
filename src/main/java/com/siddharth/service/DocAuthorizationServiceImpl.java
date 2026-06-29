package com.siddharth.service;

import com.siddharth.enums.Permission;
import com.siddharth.exception.UserNotFoundException;
import com.siddharth.model.Doc;
import com.siddharth.model.User;
import com.siddharth.repo.UserRepository;
import com.siddharth.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocAuthorizationServiceImpl implements DocAuthorizationService {

    @Autowired
    UserRepository userRepository;

    private User getCurrentUser() {
        String username = SecurityUtil.getCurrentUsername();
        User user = userRepository.findById(username).orElseThrow(() -> new UserNotFoundException());
        return user;
    }

    @Override
    public boolean canAccess(String docId) {
        User user = getCurrentUser();
        return user.getAccessDoc().stream().anyMatch(doc -> doc.getDoc().getId().equals(docId));
    }

    @Override
    public boolean canEdit(String username, Doc doc) {
        return doc.getOwner().getUsername().equals(username) || doc.getSharedWith().stream()
                .anyMatch(userDoc -> userDoc.getUser().getUsername().equals(username) && userDoc.getPermission().equals(Permission.EDIT));
    }

    public boolean fullAccess(String username, Doc doc) {
        return doc.getOwner().getUsername().equals(username);
    }
}
