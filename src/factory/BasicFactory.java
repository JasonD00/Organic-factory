package factory;

import ecosystem.Resource;

import java.util.Map;
import java.util.Random;

// Each factory has a name which is set upon creation.
// Each factory has a gene, that si stored in a map where each key is a genes name and value
public class BasicFactory implements MetaFactory {
    private final String name;
    private final Map<String, Double> genome;
    private final Random random = new Random();

    // Constructor
    public BasicFactory(String name, Map<String, Double> genome) {
        this.name = name;
        this.genome = genome;
    }

    // Get the factory name
    @Override
    public String getName() {
        return name;
    }

    // Get the factories genes
    @Override
    public Map<String, Double> getGenome() {
        return genome;
    }

    // Calculates the factories final score based on factors:
    @Override
    public double produce(Resource resource) {

        // There are 3 genes with default values, a luck factor is used to generate random numbers
        // and scaling by adaptability gene. The final score is calculated by performance, efficiency and the amount fo resources(luck factor is then added)
        double basePerformance = genome.getOrDefault("performance_gene", 1.0);
        double efficiency = genome.getOrDefault("resource_efficiency_gene", 1.0);
        double adaptability = genome.getOrDefault("adaptability_gene", 1.0);

        double luckFactor = random.nextDouble() * adaptability;
        double finalScore = (basePerformance * efficiency * resource.getAmount()) + luckFactor;

        // Ensure the score is never negative
        return Math.max(0, finalScore);
    }
}
