package spring.boot;

import javax.persistence.*;

@Entity
public class State {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "state_Id")
    private int Id;

    @Version
    private int version;

    private String stateName;
    private String stateAbbreviation;

    public State(){}
    public State(String stateName){
        this.setStateName(stateName);
    }
    public State(String stateName, String stateAbbreviation){
        this.setStateName(stateName);
        this.setStateAbbreviation(stateAbbreviation);
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

    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }
    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }
}
