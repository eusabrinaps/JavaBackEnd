package Persistence;

import model.Player;
import model.Team;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamDAO implements DAO<Team> {
    @Override
    public void insert(Team team) {
        String sql = "INSERT INTO teams (name, baseLocation, coachName, id_captain) VALUES (?,?,?,?)";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)) {
            statement.setString(1, team.getName());
            statement.setString(2, team.getBaseLocation());
            statement.setString(3, team.getCoachName());
            statement.setInt(4, team.getId_captain());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Team team) {
        String sql = "UPDATE teams SET name=?, baseLocation=?, coachName=?, id_captain=? WHERE id=?";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)) {
            statement.setString(1, team.getName());
            statement.setString(2, team.getBaseLocation());
            statement.setString(3, team.getCoachName());
            statement.setInt(4, team.getId_captain());
            statement.setInt(5, team.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM teams WHERE id=?";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }



    @Override
    public Optional<Team> findOne(int id) {
        String sql = "SELECT * FROM teams WHERE id=?";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)){
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                return Optional.of(getResultSetToEntity(rs));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    private Team getResultSetToEntity(ResultSet rs) throws SQLException {
        return new Team(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("baseLocation"),
                rs.getString("coachName"),
                rs.getInt("id_Captain"));
    }

    @Override
    public List<Team> findAll() {
        ArrayList<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM teams";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Team team = getResultSetToEntity(rs);
                teams.add(team);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return teams;
    }
}
