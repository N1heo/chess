// package kg.edu.alatoo.chess;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Component;
// import org.springframework.web.client.RestTemplate;

// import kg.edu.alatoo.chess.entity.ChessDotComPlayer;

// @Component
// public class ChessDotComApiService {
//     // private static final String CHESS_DOT_COM_API_BASE_URL = "https://api.chess.com/pub";
//     // private static final String CHESS_DOT_COM_API_PLAYER_URL = "/player/";

//     public ChessDotComPlayer getPlayerData(String username) {
//         HttpHeaders headers = new HttpHeaders();
// 		headers.setContentType(MediaType.APPLICATION_JSON);

//         RestTemplate restTemplate = new RestTemplate();
//         // String url = CHESS_DOT_COM_API_BASE_URL + CHESS_DOT_COM_API_PLAYER_URL + username;
//         String url = "https://api.chess.com/pub/{username}/{stats}";

//         HttpEntity<?> httpEntity = new HttpEntity<>(headers);

//         Map<String, String> map = new HashMap<>();
// 		map.put("username", "n1heo");
// 		map.put("stats", "stats");
        
//         ResponseEntity<ChessDotComPlayer[]> response = restTemplate.exchange(
//             url,
//             HttpMethod.GET,
//             httpEntity,
//             ChessDotComPlayer[].class,
//             map);
//         System.out.println("Status Code: " + response.getStatusCode());
//         for (ChessDotComPlayer e : response.getBody()) {
//             System.out.println(e);
//         }
//         return null;
//     }
// }
