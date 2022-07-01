package com.dailylife.domain.board.repository;

import com.dailylife.domain.board.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
