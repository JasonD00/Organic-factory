import java.util.*;

// the strategies for components for ecosystem behaviour
public class FactoryEcosystem {
    private List<MetaFactory> population;
    private final CompetitionStrategy competition; // Rules for competition
    private final ReproductionStrategy reproduction; // rules for offspring reproduction
    private final CullingStrategy culling; // Which factories survive or not
    private final GeneticFactoryBuilder builder; // Creates new factories which unique genome
    private int generationCount;
    private final Random random = new Random();

    public FactoryEcosystem(CompetitionStrategy competition, ReproductionStrategy reproduction, CullingStrategy culling, GeneticFactoryBuilder builder) {
        this.competition = competition;
        this.reproduction = reproduction;
        this.culling = culling;
        this.builder = builder;
        this.population = new ArrayList<>();
        this.generationCount = 0;


    }

    // Adds a new factory
    public void addFactory(MetaFactory factory) {
        this.population.add(factory);
    }

    // Increases the generation counter and prints messages
    public void runGeneration() {
        generationCount++;
        System.out.println("--- Generation " + generationCount + " starts. Current population: " + population.size() + "-");

        // Competition Phase:
        // Creates a random resource, factories compete over them
        //Each factory uses competition rules to calculate performance

        Map<MetaFactory, Double> scores = new HashMap<>();
        Resource resource = new Resource(random.nextDouble() * 100);

        System.out.println("--- Competition Phase: Resource amount is " + String.format("%.2f", resource.getAmount()) + " ---");
        for (MetaFactory factory : population) {
            double score = competition.evaluate(factory, resource);
            scores.put(factory, score);
           // System.out.printf(" -> Factory '%s' scored: %.2f%\n" + factory.getName(), score);
            System.out.printf(" -> Factory '%s' scored: %.2f%% \n", factory.getName(), score);
        }

        // Culling rules to look at scores and determine survivors
        // A list of the factories which have not survived are then added to a list
        // low performance factories which are culled are then printed

        List<MetaFactory> survivors = culling.cull(this.population, scores);

        System.out.println(" \n--- Culling phase: Natural Selection is occuring... ---");
        List<MetaFactory> culledFactories = new ArrayList<>(this.population);
        culledFactories.removeAll(survivors);
        for (MetaFactory factory : culledFactories) {
            System.out.printf(" -> Factory '%s' has been culled due to low performance\n" , factory.getName());


        }

        // Reproduction phase, creates a new list of offspring from the surviving factories
        // The new list becomes the new population
        List<MetaFactory> offspring = reproduction.reproduce(survivors, builder);
        this.population = offspring;

        System.out.println("\n--- Generation Summary ---");
        System.out.println(" Survivors:" + survivors.size());
        System.out.println(" Final Population: " + population.size());
        System.out.println(" --------------------------------------\n");



    }

    // How many generations will run, called through runGeneration()
    public void simulate(int generations) {
        for (int i = 0; i < generations; i++) {
            runGeneration();
        }
    }








    }


