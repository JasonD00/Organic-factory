import java.util.List;
import java.util.Map;

public interface CullingStrategy {
    List<MetaFactory> cull(List<MetaFactory> factories, Map<MetaFactory, Double > scores);
}
