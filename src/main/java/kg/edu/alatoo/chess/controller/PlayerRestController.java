package kg.edu.alatoo.chess.controller;

import kg.edu.alatoo.chess.entity.Player;
import kg.edu.alatoo.chess.repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlayerRestController {
    private final PlayerRepository playerRepository;

    public PlayerRestController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostMapping("/players")
    Player newPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/players")
    List<Player> getAllPlayers() {
        return (List) playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    Optional<Player> getOnePlayer(@PathVariable Long id) {
        return  playerRepository.findById(id);
    }

    @PutMapping("/players/{id}")
    Player updatePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {
        return playerRepository.findById(id).map(
                player -> {
                    player.setUsername(newPlayer.getUsername());
                    player.setRapid_rating(newPlayer.getRapid_rating());
                    return playerRepository.save(player);
                }).orElseGet(() -> {
                    newPlayer.setId(id);
                    return playerRepository.save(newPlayer);
                }
        );
    }

    @DeleteMapping("/player/{id}")
    void deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
    }
}