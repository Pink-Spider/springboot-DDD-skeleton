package io.pinkspider.dddskeleton.api.board;

import io.pinkspider.dddskeleton.application.board.BoardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public void create(@RequestParam Long id, @RequestParam String name) {
        boardService.handle(id, name);
    }
}
