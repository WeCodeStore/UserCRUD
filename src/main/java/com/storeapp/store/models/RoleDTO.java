package com.storeapp.store.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDTO {
    private long roleId;
    private String name;
    private List<String> userList;

    public void setUserList(List<User> userList) {

        var list = new ArrayList<String>();
        for(User user:userList){
            list.add(user.getUsername());
        }
        this.userList = list;
    }
}
