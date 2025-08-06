import java.util.List;

public interface ReproductionStrategy {
List<MetaFactory> reproduce(List<MetaFactory> parents, GeneticFactoryBuilder builder);
}
