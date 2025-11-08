package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String role;
    private int age;

    @ManyToOne
    @JoinColumn(name = "team_name")
    private Team team;

    public Player() {}

    public Player(String name, String role, int age) {
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public int getAge() { return age; }
    public Team getTeam() { return team; }

    public void setTeam(Team team) { this.team = team; }
    public void setAge(int age) { this.age = age; }
    public void setRole(String role) { this.role = role; }
}
