package com.siddharth.service;

import com.siddharth.model.Doc;

public interface DocAuthorizationService {
    boolean canAccess(String docId);
    boolean canEdit(String username, Doc doc);
    boolean fullAccess(String username, Doc doc);
}
