package strategy;

import builder.GeneticFactoryBuilder;
import factory.MetaFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// The Reproduction Strategy selects the top 50% of performers to reproduce
public class TopPerformerReproductionStrategy implements ReproductionStrategy {

    @Override
    public List<MetaFactory> reproduce(List<MetaFactory> parents, GeneticFactoryBuilder builder) {
        List<MetaFactory> offspring = new ArrayList<>();
        Random random = new Random();
        int offspringCount = parents.size(); // Offspring and parents = same size

        for(MetaFactory parent: parents) {
            String offspringName = parent.getName() + "-" + random.nextInt(100);
            MetaFactory newFactory = builder.build(offspringName, parent.getGenome());
            offspring.add(newFactory);
        }
        return offspring;
    }
}
