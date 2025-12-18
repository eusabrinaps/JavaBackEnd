package controller;

import Persistence.TeamDAO;
import model.Team;
import view.ConsoleView;

import java.sql.SQLException;
import java.util.Scanner;

public class ControllerTeam {
    private final TeamDAO teamDAO = new TeamDAO();
    private ConsoleView consoleView = new ConsoleView();
    private Scanner scanner = new Scanner(System.in);

    public void inserir(){
        System.out.println("Nome do time");
        String nome = scanner.next();
        System.out.println("BaseLocation do time");
        String baseLocation = scanner.next();
        System.out.println("CoachName do time");
        String coachName = scanner.next();
        System.out.println("id do Captain do time");
        int captain_id = Integer.parseInt(scanner.next());

        Team team;
        if(captain_id == 0){
            team = new Team(nome, baseLocation, coachName);
        }else{
            team = new Team(nome, baseLocation, coachName, captain_id);
        }
        teamDAO.insert(team);
        System.out.println("Time criado");
    }

    public void atualizar(){
        System.out.println("Nome do time para atualizar");
        String nome = scanner.next();
        System.out.println("BaseLocation do time");
        String baseLocation = scanner.next();
        System.out.println("CoachName do time");
        String coachName = scanner.next();
        System.out.println("id do Captain do time");
        int captain_id = Integer.parseInt(scanner.next());

        Team team;
        if(captain_id == 0){
            team = new Team(nome, baseLocation, coachName);
        }else{
            team = new Team(nome, baseLocation, coachName, captain_id);
        }
        teamDAO.update(team);
        System.out.println("Time criado");
    }

    public void remover() throws SQLException {
        try {
            System.out.println("ID do time para remover");
            int id = Integer.parseInt(scanner.next());
            if(id != 0){
                teamDAO.delete(id);
            }
        } catch (NumberFormatException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listar(){
        try {
            System.out.println("ID do time para listar: ");
            int id = Integer.parseInt(scanner.next());
            if(id != 0){
                System.out.println(teamDAO.findOne(id));
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public void listarTodos(){
        try {
            System.out.println("Listando todos os time:\n ");
            teamDAO.findAll().forEach(System.out::println);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
