package com.storeapp.store.repository;

import com.storeapp.store.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
//
//    @Query(value = "select USERTABLE.USERID, USERTABLE.FIRSTNAME, USERTABLE.LASTNAME, USERTABLE.USERNAME, USERROLES.ROLE_ID, ROLE.NAME from USERTABLE inner join USERROLES on USERROLES.USER_ID = USERTABLE.USERID inner join ROLE on USERROLES.ROLE_ID = ROLE.ROLEID", nativeQuery = true)
//    List<UserWithRole> getUsersWithRoles();


//    select USERTABLE.USERID, USERTABLE.FIRSTNAME, USERTABLE.LASTNAME, USERTABLE.USERNAME, USERROLES.ROLE_ID, ROLE.NAME from USERTABLE inner join USERROLES on USERROLES.USER_ID = USERTABLE.USERID inner join ROLE on USERROLES.ROLE_ID = ROLE.ROLEID
}
