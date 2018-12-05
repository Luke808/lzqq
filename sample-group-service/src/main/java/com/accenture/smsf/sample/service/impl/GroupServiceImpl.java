package com.accenture.smsf.sample.service.impl;

import com.accenture.smsf.framework.boot.stereotype.Service;
import com.accenture.smsf.sample.core.entity.Group;
import com.accenture.smsf.sample.core.mapper.GroupMapper;
import com.accenture.smsf.sample.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

@Service//服务层
public class GroupServiceImpl implements GroupService {

    @Autowired//注入
    private GroupMapper groupMapper;

    @Override
    @Cacheable(value = "sample", keyGenerator = "cacheKeyGenerator")//缓冲
    public Group findGroup(String id) {
        return groupMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addGroup(Group group) {
        return groupMapper.insert(group);
    }

    @Override
    public Integer updateGroup(Group group) {
        return groupMapper.updateByPrimaryKeySelective(group);
    }

    @Override
    public Integer deleteGroup(String id) {
        return groupMapper.deleteByPrimaryKey(id);
    }
}
