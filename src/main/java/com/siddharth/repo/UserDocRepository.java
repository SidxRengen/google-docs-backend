package com.siddharth.repo;

import com.siddharth.model.UserDoc;
import com.siddharth.model.UserDocId;
import com.siddharth.enums.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserDocRepository extends JpaRepository<UserDoc, UserDocId> {

    @Modifying
    @Transactional
    @Query("delete from UserDoc ud where ud.userDocId.username = ?1 and ud.userDocId.docId = ?2 and (select d.owner.username from Doc d where d.id = ?2) = ?3")
    int deleteUserDocBy(String username, Long docId, String owner);

    @Modifying
    @Transactional
    @Query("update UserDoc ud set ud.permission = ?4 where ud.userDocId.username = ?1 and ud.userDocId.docId = ?2 and (select d.owner.username from Doc d where d.id = ?2) = ?3")
    int updateUserDocBy(String username, Long docId, String owner, Permission permission);

}
