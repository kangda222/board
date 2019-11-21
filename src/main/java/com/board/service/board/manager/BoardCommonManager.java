package com.board.service.board.manager;

import com.board.DTO.BoardDTO;

public interface BoardCommonManager {

    public String getType();

    public BoardDTO update(BoardDTO board) throws Exception;

    public int delete(int id) throws Exception;
}
