package Persistence;

import model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerDAO implements DAO<Player> {

    @Override
    public void insert(Player player) {
        String sql = "INSERT INTO players (name, number, position, isFielded, id_team) VALUES (?,?,?,?,?)";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)) {
            statement.setString(1, player.getName());
            statement.setInt(2, player.getNumber());
            statement.setString(3, player.getPosition());
            statement.setBoolean(4, player.isFielded());
            statement.setInt(5, player.getId_team());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Player player) {
        String sql = "UPDATE players SET name =?, number=?, position=?, isFielded=?, id_team=? WHERE id=?";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)) {
            statement.setString(1, player.getName());
            statement.setInt(2, player.getNumber());
            statement.setString(3, player.getPosition());
            statement.setBoolean(4, player.isFielded());
            statement.setInt(5, player.getId_team());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM players WHERE id=?";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    private Player getResultSetToEntity(ResultSet rs) throws SQLException {
        return new Player(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("number"),
                rs.getString("postion"),
                rs.getBoolean("isFielded"),
                rs.getInt("id_team"));
    }


    @Override
    public Optional<Player> findOne(int id) {
        String sql = "SELECT * FROM players WHERE id=?";
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

    @Override
    public List<Player> findAll() {
        ArrayList<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM players";
        try(var statement = ConnectionFactory.getPreparedStatement(sql)){
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Player player = getResultSetToEntity(rs);
                players.add(player);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return players;
    }
}
