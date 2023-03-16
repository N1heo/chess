// package kg.edu.alatoo.chess.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.ui.Model;

// import kg.edu.alatoo.chess.ChessDotComApiService;
// import kg.edu.alatoo.chess.entity.ChessDotComPlayer;

// @Controller
// public class MyController {
//     @Autowired
//     private ChessDotComApiService chessDotComApiService;

//     @GetMapping("/index")
//     public ChessDotComPlayer index(Model model) {
//         ChessDotComPlayer player = chessDotComApiService.getPlayerData("n1heo");
//         model.addAttribute("player", player);
//         return chessDotComApiService.getPlayerData("n1heo");
//     }
// }
