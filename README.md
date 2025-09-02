This project is a meta-factory based idea using the CLI. In this system, factories produce outputs based on resource input and internal genetic configurations.  
These factories evolve over time through 3 main processes:

- Evaluation  
- Culling  
- Reproduction  

The main aim of this project was to build a conceptual factory designed to mimic evolutionary systems and show abstract simulation logic.  

The Core Conecpts:

- **MetaFactory**: A factory with its own genome which determines how its own resources are processed.  
- **Resource**: Consists of input values which are consumed by factories to generate a score.  
- **CompetitionStartegy**: Determines how factories are evaluated.  
- **CullingStrategy**: Selects the bottom performing factories and removes them.  
- **ReproductionStrategy**: Generates new factories by copying the top performers and mutating their genes.  

Design Patterns Used:

- Factory Design Pattern  
- Strategy Pattern (for the 3 main processes)  

Technologies:

- Java  
- OOP Design Principles  

How It Works:

- Factories are initialized with random genomes.  
- Each factory consumes a resource and is evaluated via a CompetitionStrategy.  
- The CullingStrategy removes the bottom 30% performers.  
- The ReproductionStrategy creates new factories from the survivors.  
- The process repeats for multiple generations.
