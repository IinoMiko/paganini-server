package xyz.yuanzhi.paganiniserver.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class SongList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer collectId;

    private Integer songId;

    public SongList(Integer collectId, Integer songId){
        this.collectId = collectId;
        this.songId = songId;
    }

}
