package xyz.yuanzhi.paganiniserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        List<Song> songs = songService.searchSongsByString("%" + name + "%");
        message.addSuccessMsg("搜索成功");
        message.setObject(songs);
        return message.toJson();
    }

    @PostMapping(value = "addSong")
    public String addSong(@RequestBody Song song){
        Message message = new Message();
        Song result = songService.addOrModifySong(song);
        if (result == null){
            message.addFailMsg("添加失败");
            message.setObject(new Song());
        } else {
            message.addSuccessMsg("添加成功");
            message.setObject(result);
        }
        return message.toJson();
    }

    @PutMapping(value = "modify")
    public String modify(@RequestBody Song song){
        Message message = new Message();
        Song result = songService.addOrModifySong(song);
        message.addMessage(result != null, "修改成功", "修改失败");
        return message.toJson();
    }

    @DeleteMapping(value = "songId={songId}")
    public String deleteSong(@PathVariable Integer songId){
        Message message = new Message();
        songService.deleteAllBySongId(songId);
        message.addSuccessMsg("删除成功");
        return message.toJson();
    }

}
