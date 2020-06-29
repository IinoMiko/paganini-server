package xyz.yuanzhi.paganiniserver.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Collect {

    public static final Integer SYSTEM_LIST = 0; //系统歌单
    public static final Integer USER_LIST = 1; //用户歌单

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer collectId;

    private Integer userId;

    private Integer type;

    private Date createTime;

    private String pic;

    private String style;

}
