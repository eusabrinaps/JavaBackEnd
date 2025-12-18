package model;

import java.util.Objects;

public class Player {
    private int id;
    private String name;
    private int number;
    private String position;
    private boolean isFielded;
    private Team team;
    private int id_team;

    public Player(String name, int number, String position, boolean isFielded, int id_team) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
        this.id_team = id_team;
    }
    public Player(String name, int number, String position, boolean isFielded) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    public Player(int id, String name, int number, String position, boolean isFielded, int id_team) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
        this.id_team = id_team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", position='" + position + '\'' +
                ", isFielded=" + isFielded +
                ", team=" + team +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Integer getId_team() {
        return id_team;
    }

    public void setId_team(Integer id_team) {
        this.id_team = id_team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isFielded() {
        return isFielded;
    }

    public void setFielded(boolean fielded) {
        isFielded = fielded;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
