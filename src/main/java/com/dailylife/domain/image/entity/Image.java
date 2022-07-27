package com.dailylife.domain.image.entity;

import com.dailylife.domain.board.entity.Board;
import com.dailylife.domain.image.dto.BoardImageRequest;
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
    @JoinColumn(name="board_boardNum")
    Board board;

    public static Image toEntity(String imageName, Board board){
        Image build = new Image.ImageBuilder()
               .imageName(imageName).build();
                build.setBoard(board);
        return build;
    }
}
