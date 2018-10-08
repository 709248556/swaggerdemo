package com.example.swaggerdemo.controller;


import com.example.swaggerdemo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "/user", tags = "用户模块")
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiOperation(value = "展示用户信息",notes = "展示用户")
    @GetMapping("/userList")
    public List<User> getUserlist() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setSex("男");
            user.setAge(i);
            user.setUsername("test" + i);
            users.add(user);
        }
        return users;
    }
    @ApiOperation(value = "用户添加",notes = "添加用户")
    @ApiImplicitParam(name = "user",value = "User",required = true,dataType ="User")
    @PostMapping(value = "/addUser")
    public String addUser(User user){
        return "添加成功";
    }
    @ApiOperation(value = "删除用户",notes = "删除用户")
    @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "int",paramType = "path")
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")int id){
        return "删除成功";
    }
    @ApiOperation(value = "修改用户",notes = "修改用户")
    @PutMapping("/updateUser")
    @ApiImplicitParam(name = "user",value = "User",required = true,dataType = "User")
    public String updateUser(User user){
        return "修改成功";
    }
}
