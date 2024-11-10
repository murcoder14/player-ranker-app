package dev.muralis.playerrank.controller;

import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tennis")
public class RankingController {

    private static final Logger logger = LoggerFactory.getLogger(RankingController.class);
    private static Random random = new Random();

    private static final Map<String, Integer> RANKINGS = Map.of(
            "Jannik Sinner", 1,
            "Alex Zverev", 2,
            "Carlos Alcaraz",3,
            "Daniil Medvedev",4,
            "Novak Djikovic",5
    );

    @GetMapping("ranking/{player}")
    public int getRanking(@PathVariable String player) {
        logger.info("Preparing ranking for player {}", player);
        if (RANKINGS.containsKey(player))
               return RANKINGS.get(player);
        throw new RuntimeException(player + " is not currently ranked in the top 5!");
    }

}
