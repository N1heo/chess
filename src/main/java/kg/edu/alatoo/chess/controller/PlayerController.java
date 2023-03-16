package kg.edu.alatoo.chess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import kg.edu.alatoo.chess.entity.Player;
import kg.edu.alatoo.chess.repository.PlayerRepository;
import kg.edu.alatoo.chess.util.HttpRequest;

@Controller
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;
    
    @GetMapping(value = "/")
    public String getPlayer(Model model) {
        try {
            HttpRequest request = HttpRequest
                    .get("https://api.chess.com/pub/player/n1heo/stats")
                    .connectTimeout(120000);
            String res = request.body();
            ObjectMapper mapper = new ObjectMapper();
            Player player = new Player();
            JsonNode node = mapper.readTree(res);
            player.setRapid_rating(node.get("chess_rapid").get("last").get("rating").asInt());
            playerRepository.save(player);
            model.addAttribute("players", playerRepository.findAll());
            return "index";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}
