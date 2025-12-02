package io.pinkspider.dddskeleton.application.board;

import io.pinkspider.dddskeleton.domain.board.Board;
import io.pinkspider.dddskeleton.domain.board.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void handle(Long id, String name) {
        Board board = new Board(id, name);
        boardRepository.save(board);
    }
}
