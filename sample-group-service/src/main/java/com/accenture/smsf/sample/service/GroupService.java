package com.accenture.smsf.sample.service;

import com.accenture.smsf.sample.core.entity.Group;

public interface GroupService {

    Group findGroup(String id);
    Integer addGroup(Group group);
    Integer updateGroup(Group group);
    Integer deleteGroup(String id);
}
