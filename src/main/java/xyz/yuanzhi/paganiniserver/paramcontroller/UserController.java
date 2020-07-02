package xyz.yuanzhi.paganiniserver.paramcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.yuanzhi.paganiniserver.domain.User;
import xyz.yuanzhi.paganiniserver.service.UserServiceImpl;
import xyz.yuanzhi.paganiniserver.util.JacksonUtil;
import xyz.yuanzhi.paganiniserver.util.Message;
import xyz.yuanzhi.paganiniserver.util.MyJson;

@RestController
@RequestMapping(value = "/web/user/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "login")
    public Object login(@RequestParam User user){
        MyJson message = new MyJson();
        String name = user.getName();
        String password = user.getPassword();
        User foundUser = userService.getUser(name, password);
        if(foundUser == null){
            message.addFailMsg("用户名或密码错误");
        } else {
            message.addSuccessMsg("登录成功");
            message.setObject(foundUser);
        }
        return message.getJsonObject();
    }

    @PostMapping(value = "register")
    public Object register(@RequestBody User user){
        String name = user.getName();
        MyJson message = new MyJson();

        if (!userService.searchUser(name)){
            message.setObject(userService.addUser(user));
            message.addSuccessMsg("注册成功");
        } else {
            message.addFailMsg("已存在该用户");
        }
        return message.getJsonObject();
    }

    @GetMapping(value = "/user/userId={userId}")
    public String getUser(@PathVariable Integer userId){
        Message message = new Message();
        User user = userService.getUser(userId);
        if(user != null){
            message.setObject(user);
            message.addSuccessMsg("获取成功");
        } else {
            message.setObject(new User());
            message.addFailMsg("获取失败");
        }
        return message.toJson();
    }

    @GetMapping(value = "/user/id={id}")
    public String getManageUser(@PathVariable Integer id){
        Message message = new Message();
        User user = userService.getUser(id);
        return JacksonUtil.Bean2Json(user);
    }

    @PutMapping(value = "modify")
    public String modifyUser(@RequestBody User user){
        userService.addUser(user); //这里其实都是调用save()方法，只要保证主键相等就能覆盖
        Message message = new Message();
        message.addSuccessMsg("修改成功");
        return message.toJson();
    }

    @DeleteMapping(value = "userId={userId}")
    public String deleteUser(@PathVariable Integer userId){
        userService.deleteAllByUserId(userId);
        Message message = new Message();
        message.addSuccessMsg("删除成功");
        return message.toJson();
    }

    @GetMapping(value = "all")
    public String getAllUser(){
        return JacksonUtil.Bean2Json(userService.getAllUsers());
    }
}
