package xyz.yuanzhi.paganiniserver.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "singer")
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "singer_id")
    private Integer singerId;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "pic")
    private String pic;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "location")
    private String location;

}
