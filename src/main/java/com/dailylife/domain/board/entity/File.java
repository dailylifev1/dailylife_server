package com.dailylife.domain.board.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tbl_file")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class File{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

        private String originFileName;
        private String fullPath;
}
