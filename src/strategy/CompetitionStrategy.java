package strategy;

import ecosystem.Resource;
import factory.MetaFactory;

// How the factories are evaluated against each other.
public interface CompetitionStrategy {

    // Calculating score  based on performance based on resources
    double evaluate(MetaFactory factory, Resource resource);

}
