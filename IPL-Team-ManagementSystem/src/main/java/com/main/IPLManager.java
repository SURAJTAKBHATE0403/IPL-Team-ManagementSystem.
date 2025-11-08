package com.main;

import com.dao.PlayerDAO;
import com.dao.TeamDAO;
import com.entity.Player;
import com.entity.Team;
import java.util.Scanner;

public class IPLManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TeamDAO teamDAO = new TeamDAO();
        PlayerDAO playerDAO = new PlayerDAO();

        while (true) {
            System.out.println("\n1. Add Team");
            System.out.println("2. Add Player to Team");
            System.out.println("3. Display Teams");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Team Name: ");
                String teamName = sc.nextLine();
                teamDAO.saveTeam(new Team(teamName));

            } else if (choice == 2) {
                System.out.print("Enter Team Name: ");
                String teamName = sc.nextLine();
                System.out.print("Enter Player Name: ");
                String playerName = sc.nextLine();
                System.out.print("Enter Role: ");
                String role = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                Player player = new Player(playerName, role, age);
                playerDAO.savePlayer(player);
            } else if (choice == 4) break;
        }
    }
}
