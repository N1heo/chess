package kg.edu.alatoo.chess.entity;

import jakarta.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String full_name;
    
    @Column 
    private Integer rapid_rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Integer getRapid_rating() {
        return rapid_rating;
    }

    public void setRapid_rating(Integer rapid_rating) {
        this.rapid_rating = rapid_rating;
    }



}
