package xyz.yuanzhi.paganiniserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yuanzhi.paganiniserver.domain.Song;
import xyz.yuanzhi.paganiniserver.service.SongServiceImpl;
import xyz.yuanzhi.paganiniserver.util.Message;

import java.util.List;

@RestController
@RequestMapping(value = "/song/")
public class SongController {

    @Autowired
    private SongServiceImpl songService;

    @GetMapping(value = "songId={songId}")
    public String getSongById(@PathVariable Integer songId){
        Message message = new Message();
        Song song = songService.getSongById(songId);
        if(song == null){
            message.addFailMsg("获取歌曲信息失败");
            message.setObject(new Song());
        } else {
            message.addSuccessMsg("成功获取歌曲信息");
            message.setObject(song);
        }
        return message.toJson();
    }

    @GetMapping(value = "search/name={name}")
    public String searchSong(@PathVariable String name){
        Message message = new Message();
        List<Song> songs = songService.searchSongsByString(name);
        message.addSuccessMsg("搜索成功");
        message.setObject(songs);
        return message.toJson();
    }

}
