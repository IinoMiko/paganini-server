package xyz.yuanzhi.paganiniserver.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private Integer songId;

    @Column(name = "name")
    private String name;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "pic")
    private String pic;

    @Column(name = "lyric")
    private String lyric;

    @Column(name = "style")
    private String style;

    @Column(name = "url")
    private String url;

}
