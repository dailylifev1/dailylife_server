package com.dailylife.domain.heart.entity;

import com.dailylife.domain.heart.dto.HeartStateRequest;
import com.dailylife.domain.reply.entity.Reply;

import com.dailylife.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity(name = "tbl_heart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Heart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long heartNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rno")
    private Reply reply;

    private Long uno;

    private Long heartState;

    public static Heart toEntity(HeartStateRequest heartStateRequest, Reply reply){
        Heart build =  Heart.builder()
                .heartState(heartStateRequest.getHeartState())
                .uno(heartStateRequest.getUno())
                .build();
        build.setReply(reply);
        return build;
    }



}
