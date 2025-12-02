package io.pinkspider.dddskeleton.infrastructure.board;

import io.pinkspider.dddskeleton.domain.board.Board;
import io.pinkspider.dddskeleton.domain.board.BoardRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBoardRepository implements BoardRepository {
    @Override
    public Board findById(Long id) {
        return new Board(id, "Sample");
    }

    @Override
    public void save(Board board) {
        System.out.println("Saved board: " + board.getName());
    }
}
