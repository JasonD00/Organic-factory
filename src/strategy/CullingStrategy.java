package strategy;

import factory.MetaFactory;

import java.util.List;
import java.util.Map;

// The rules for how low performing factories are removed from the population
public interface CullingStrategy {

    // Takes the population and their scores, then return an unfiltered list of survivors
    List<MetaFactory> cull(List<MetaFactory> factories, Map<MetaFactory, Double > scores);
}
