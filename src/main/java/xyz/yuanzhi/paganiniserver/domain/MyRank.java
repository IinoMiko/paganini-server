package xyz.yuanzhi.paganiniserver.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "my_rank")
public class MyRank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rank_id")
    private Integer rankId;

    @Column(name = "song_id")
    private Integer songId;

    @Column(name = "score")
    private Double score;

}
