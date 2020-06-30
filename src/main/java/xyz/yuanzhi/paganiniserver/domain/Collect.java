package xyz.yuanzhi.paganiniserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "collect")
public class Collect {

    public static final Integer SYSTEM_LIST = 0; //系统歌单
    public static final Integer USER_LIST = 1; //用户歌单

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collect_id")
    private Integer collectId;

    private String name;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "type")
    private Integer type;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "pic")
    private String pic;

    @Column(name = "style")
    private String style;

    private String introduction;

    @Transient
    @JsonIgnore
    private List<Song> songs;

}
