package com.dailylife.domain.board.entity;

import com.dailylife.domain.board.dto.BoardImageRequest;
import lombok.*;

import javax.persistence.*;

@Entity(name = "tbl_board_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageNum;

    private String imageName;

    @ManyToOne
    @JoinColumn(name="bno")
    Board board;

    public static Image toEntity(BoardImageRequest boardImageRequest, Board board){
        Image build = new ImageBuilder()
                .imageName(boardImageRequest.getImgName()).build();
                build.setBoard(board);
        return build;
    }
}
