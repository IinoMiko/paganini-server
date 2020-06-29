package xyz.yuanzhi.paganiniserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yuanzhi.paganiniserver.domain.Singer;
import xyz.yuanzhi.paganiniserver.service.SingerServiceImpl;
import xyz.yuanzhi.paganiniserver.util.Message;

@RestController
@RequestMapping(value = "/singer/")
public class SingerController {

    @Autowired
    private SingerServiceImpl singerService;

    @GetMapping(value = "singerId={singerId}")
    public String getSingerById(@PathVariable Integer singerId){
        Message message = new Message();
        Singer singer = singerService.getSingerById(singerId);
        if(singer == null){
            message.addFailMsg("获取歌手信息失败");
            message.setObject(new Singer());
        } else {
            message.addSuccessMsg("成功获取歌手信息");
            message.setObject(singer);
        }
        return message.toJson();
    }
}
