import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// GeneticFactoryBuilder builds a new MetaFactory. Takes genes from existing factories and creates new ones with a new set
public class GeneticFactoryBuilder {

    private final Random random = new Random();

    // The name for the new factory, the set of genes from the parent factory
    public MetaFactory build(String name, Map<String, Double> parentGenome) {
       // Makes a copy of the parents' genes. The new set is the offspring
        Map<String, Double> offspringGenome = new HashMap<>(parentGenome);

        // Small random gene mutations that go to the offsprings genes
        // Goes through each gene in the new offspring and causes a negative or positive mutation
        for (Map.Entry<String, Double> gene : offspringGenome.entrySet()) {
            double mutation = (random.nextDouble() - 0.5) * 0.1; // Smaller random value
            gene.setValue(gene.getValue() + mutation); // Mutation is applied to the gene's value

        }

        // After genes are mutated, the code creates a new BasicFactory using a new name and slightly altered genes
return new BasicFactory(name, offspringGenome);
    }
}