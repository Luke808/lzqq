package com.accenture.smsf.sample.controller;

import com.accenture.smsf.framework.starter.web.core.annotation.RestController;
import com.accenture.smsf.sample.core.entity.Group;
import com.accenture.smsf.sample.service.GroupService;
import com.netflix.discovery.converters.Auto;
import net.bytebuddy.description.NamedElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;

@Validated
@RestController//控制层
public class SampleController {

    @Autowired//注入
    private GroupService groupService;

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String Hello(@RequestParam("name") String name) {
        Cache cache = cacheManager.getCache("sample");
        if (cache.get("xxx") == null) {
            cache.put("xxx", "Hello " + name);
        }
        return cache.get("xxx").get().toString();
    }

    @RequestMapping(value = "/find-group", method = RequestMethod.GET)
    public Group findGroup(@RequestParam("id") @NotBlank String id) {

        return groupService.findGroup(id);
    }

    @RequestMapping(value = "/add-group", method = RequestMethod.POST)
    public int addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
    }

    @RequestMapping(value = "/update-group", method = RequestMethod.POST)
    public int updateGroup(@RequestBody Group group) {
        return groupService.updateGroup(group);
    }

    @RequestMapping(value = "/delete-group", method = RequestMethod.GET)
    public int deleteGroup(@RequestParam("id") String id) {
        return groupService.deleteGroup(id);
    }
}
