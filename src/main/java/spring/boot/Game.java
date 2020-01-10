package spring.boot;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_Id")
    private int Id;

    @Version
    private int version;

    private String gameName;

    @ManyToMany
    private List<State> stateList;

    public Game() {}
    public Game(String gameName){
        this.setGameName(gameName);
    }

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    public String getGameName() {
        return gameName;
    }
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<State> getStateList() {
        return stateList;
    }
    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
}
