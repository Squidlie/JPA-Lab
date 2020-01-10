package spring.boot;

import javax.persistence.*;

@Entity
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prize_Id")
    private int Id;

    @Version
    private int version;

    private String match;
    private String win;
    private String odds;

    @ManyToOne
    private Game game;

    public Prize(){}
    public Prize(String match){
        this.setMatch(match);
    }
    public Prize(String match, String win){
        this.setMatch(match);
        this.setWin(win);
    }
    public Prize(String match, String win, String odds){
        this.setMatch(match);
        this.setWin(win);
        this.setOdds(odds);
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

    public String getMatch() {
        return match;
    }
    public void setMatch(String match) {
        this.match = match;
    }

    public String getWin() {
        return win;
    }
    public void setWin(String win) {
        this.win = win;
    }

    public String getOdds() {
        return odds;
    }
    public void setOdds(String odds) {
        this.odds = odds;
    }

    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
}
