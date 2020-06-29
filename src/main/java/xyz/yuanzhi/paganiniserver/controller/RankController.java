package xyz.yuanzhi.paganiniserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yuanzhi.paganiniserver.service.RankServiceImpl;
import xyz.yuanzhi.paganiniserver.util.Message;

@RestController
public class RankController {

    @Autowired
    private RankServiceImpl rankService;

    @GetMapping(value = "/getRanks")
    public String getRanks(){
        Message message = new Message();
        message.setObject(rankService.getRanks());
        message.addSuccessMsg("成功获取排行榜");
        return message.toJson();
    }

}
