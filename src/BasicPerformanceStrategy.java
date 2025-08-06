public class BasicPerformanceStrategy implements CompetitionStrategy{

    //Using CompetitionStrategy as the factory Score
    @Override
    public double evaluate(MetaFactory factory, Resource resource) {
        return factory.produce(resource);
    }
}
