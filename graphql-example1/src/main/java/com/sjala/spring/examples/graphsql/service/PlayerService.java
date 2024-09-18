package com.sjala.spring.examples.graphsql.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import com.sjala.spring.examples.graphsql.model.Player;
import com.sjala.spring.examples.graphsql.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {
    private List<Player> players = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    public List<Player> findAll() {
        return players;
    }

    public Optional<Player> findOne(Integer id) {
        return players.stream()
                .filter(player -> player.Id() == id).findFirst();
    }

    public Player create(String name, Team team) {
        Player player = new Player(id.incrementAndGet(), name, team);
        players.add(player);
        return player;
    }

    public Player delete(Integer id) {
        Player player = players.stream().filter(c -> c.Id() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
        players.remove(player);
        return player;
    }

    public Player update(Integer id, String name, Team team) {
        Player updatedPlayer = new Player(id, name, team);
        Optional<Player> optional = players.stream()
                .filter(c -> c.Id() == id).findFirst();

        if (optional.isPresent()) {
            Player player = optional.get();
            int index = players.indexOf(player);
            players.set(index, updatedPlayer);
        } else {
            throw new IllegalArgumentException("Invalid Player");
        }
        return updatedPlayer;
    }

    @PostConstruct
    private void init() {
        players.add(new Player(id.incrementAndGet(), "David Andrews", Team.PATRIOT));
        players.add(new Player(id.incrementAndGet(), "Jaheim Bell", Team.PATRIOT));
        players.add(new Player(id.incrementAndGet(), "Alex Anzalone", Team.DETROIT));
        players.add(new Player(id.incrementAndGet(), "Deonte Banks", Team.GIANTS));
        players.add(new Player(id.incrementAndGet(), "Cal Adomitis", Team.CINCINATTI));
    }
}
