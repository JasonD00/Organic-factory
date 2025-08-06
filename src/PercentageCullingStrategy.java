import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PercentageCullingStrategy implements CullingStrategy {

    // Culling strategy to cull the bottom 30% of the population
    @Override
    public List<MetaFactory> cull(List<MetaFactory> factories, Map<MetaFactory, Double> scores) {
        int cullCount = (int) (factories.size() * 0.3); // Takes the total number of factories, multiplies it by 0.3 and rounds to a whole number

        return scores.entrySet().stream()
                .sorted(Map.Entry.<MetaFactory, Double>comparingByValue().reversed()) // Sorts highest to lowest
                .limit(factories.size() - cullCount) // Only takes the list of factories which survive after the cull count
                // Collects the survivors
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }
}
