package main;

import builder.GeneticFactoryBuilder;
import ecosystem.FactoryEcosystem;
import factory.BasicFactory;
import strategy.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Simulation {
    public static void main(String[] args) {

        // Components of the specified Ecosystem (Rules are created)
        CompetitionStrategy competition = new BasicPerformanceStrategy();
        ReproductionStrategy reproduction = new TopPerformerReproductionStrategy();
        CullingStrategy culling = new PercentageCullingStrategy();
        GeneticFactoryBuilder builder = new GeneticFactoryBuilder();

        // Creation of the Ecosystem
        FactoryEcosystem ecosystem = new FactoryEcosystem(competition, reproduction, culling, builder);

        //For creating base population
        for (int i = 0; i < 10; i++) {
            Map<String, Double> initialGenome = new HashMap<>();
            initialGenome.put("performance_gene", new Random().nextDouble() * 1.5);
            initialGenome.put("resource_efficiency_gene", new Random().nextDouble());
            initialGenome.put("adaptability_gene" , new Random().nextDouble());
            ecosystem.addFactory(new BasicFactory("Initial" + i, initialGenome));
        }

        // The generations which will run
        ecosystem.simulate(4);
    }
}