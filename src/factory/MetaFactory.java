package factory;

import ecosystem.Resource;

import java.util.Map;

// Representation of a single organism in the ecosystem, and is the blueprint for each factory
// Methods define the public actions and data the ecosystem can affect
public interface MetaFactory {

    String getName(); // Unique name
    Map<String, Double> getGenome(); // Factories genetic data, map of genes names and values
    double produce(Resource resource); // Calculating performance score for each generation, taking resources into account

}
