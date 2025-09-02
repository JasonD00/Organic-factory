package strategy;

import ecosystem.Resource;
import factory.MetaFactory;

public class BasicPerformanceStrategy implements CompetitionStrategy {

    //Using strategy.CompetitionStrategy as the factory Score
    @Override
    public double evaluate(MetaFactory factory, Resource resource) {
        return factory.produce(resource);
    }
}
