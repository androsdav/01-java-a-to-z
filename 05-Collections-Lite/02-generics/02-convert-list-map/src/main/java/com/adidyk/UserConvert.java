package com.adidyk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {

    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> mapUser = new HashMap<>();
        for (User user : list) {
            mapUser.put(user.getId(), user);
        }
        return mapUser;

    }
}
