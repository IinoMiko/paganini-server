package xyz.yuanzhi.paganiniserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "song_list")
@NoArgsConstructor
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
