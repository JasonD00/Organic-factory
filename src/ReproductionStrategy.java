import java.util.List;

// For defining how new factories are created.
public interface ReproductionStrategy {

    // The list of parents are taken and a GeneticFactoryBuilder returns the offspring
List<MetaFactory> reproduce(List<MetaFactory> parents, GeneticFactoryBuilder builder);
}
