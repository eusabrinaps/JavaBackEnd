package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Team {
    private int id;
    private String name;
    private final String baseLocation;
    private String coachName;
    private Player captain;
    private int id_captain;
    private final ArrayList<Player> players;

    public Team(String name, String baseLocation, String coachName, int id_captain) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        this.captain = captain;
        this.players = new ArrayList<>();
    }
    public Team(String name, String baseLocation, String coachName) {
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        this.players = new ArrayList<>();
    }
    public Team(int id, String name, String baseLocation, String coachName, int id_captain) {
        this.id = id;
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
        this.id_captain = id_captain;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if(player == null) return;
        players.add(player);
    }
    public void removePlayer(Player player) {
        if(player == null) return;
        players.remove(player);
    }
    public void substitute(Player substitute, Player starter) {
        if(substitute == null) return;
        if(starter == null) return;
        starter.setFielded(false);
        substitute.setFielded(true);
    }
    public void setCaptain(Player captain) {
        if(captain == null) return;
        if(captain.getTeam() == null || !captain.getTeam().equals(this)) return;
        this.captain = captain;
    }
    public List<Player> getFieldedPlayers(){
        return players.stream()
                .filter(Player::isFielded).collect(Collectors.toList());
    }
    public List<Player> getOutfieldedPlayers(){
        return players.stream()
                .filter(p -> !p.isFielded()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseLocation='" + baseLocation + '\'' +
                ", coachName='" + coachName + '\'' +
                ", captain=" + captain +
                ", players=" + players +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public int getId_captain() {
        return id_captain;
    }

    public void setId_captain(int id_captain) {
        this.id_captain = id_captain;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public String getCoachName() {
        return coachName;
    }

    public Player getCaptain() {
        return captain;
    }

    public ArrayList<Player> getPlayers() {
        return new ArrayList<Player>(players);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
