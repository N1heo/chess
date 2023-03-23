package kg.edu.alatoo.chess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import kg.edu.alatoo.chess.entity.Player;
import kg.edu.alatoo.chess.repository.PlayerRepository;
import kg.edu.alatoo.chess.util.HttpRequest;

@Controller
public class PlayerController {

    @Autowired
    PlayerRepository playerRepository;
    
    @GetMapping("/table")
    public String getPlayer(Model model) {
        try {
            System.out.println("Get works");
            model.addAttribute("players", playerRepository.findAll());
            return "table";
        }catch (Exception e){
            e.printStackTrace();
            return "table";
        }
    }

    @PostMapping("/table")
    public String setPlayer(@RequestParam String username,
                            Model model, RedirectAttributes redirAttrs) throws JsonMappingException, JsonProcessingException {
        try{
            System.out.println("Post works");
            String url = "https://api.chess.com/pub/player/" + username ;
            HttpRequest request = HttpRequest
                    .get(url)
                    .connectTimeout(120000);
            String res = request.body();

            ObjectMapper mapper = new ObjectMapper();
            Player player = new Player();
            JsonNode node = mapper.readTree(res);

            player.setUsername(username);

            if((node.get("name")) != null){
                player.setFull_name(node.get("name").asText());
            } else{
                player.setFull_name("-");
            }

            url = "https://api.chess.com/pub/player/" + username + "/stats";

            request = HttpRequest
                    .get(url)
                    .connectTimeout(120000);
            res = request.body();

            node = mapper.readTree(res);

            player.setRapid_rating(node.get("chess_rapid").get("last").get("rating").asInt());

            playerRepository.save(player);

            model.addAttribute("players", playerRepository.findAll());

            return "table";
        } catch (java.lang.NullPointerException e){
            // e.printStackTrace();
            model.addAttribute("players", playerRepository.findAll());
            redirAttrs.addFlashAttribute("error", "No such user exists.");
            return "redirect:/table";
        } catch (org.springframework.dao.DataIntegrityViolationException ex){
            // ex.printStackTrace();
            model.addAttribute("players", playerRepository.findAll());
            redirAttrs.addFlashAttribute("error", "User already in the table.");
            return "redirect:/table";
        }
        
    }
}
