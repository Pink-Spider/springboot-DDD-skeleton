package io.pinkspider.dddskeleton.domain.board;

public interface BoardRepository {
    Board findById(Long id);
    void save(Board board);
}
