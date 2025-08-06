import java.util.Map;

public interface MetaFactory {
    String getName();
    Map<String, Double> getGenome();
    double produce(Resource resource);

}
