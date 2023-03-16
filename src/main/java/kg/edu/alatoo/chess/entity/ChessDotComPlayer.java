package kg.edu.alatoo.chess.entity;

import jakarta.persistence.*;

@Entity
public class ChessDotComPlayer {

    @Column
    private String username;
    
    @Column 
    private String country;

    @Column 
    private String chess_blitzrating;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



}
