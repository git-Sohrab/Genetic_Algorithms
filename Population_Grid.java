public class Population_Grid {

    Individual_Grid[] population;
    int SIZE;
    private String target;                // Target phrase
    int generations;              // Number of generations
    private boolean finished;             // Are we finished evolving?
    private int perfectScore;

    Population_Grid(String p, int populationSize) {
        target = p;
        population = new Individual_Grid[populationSize];
        SIZE = populationSize;
        for (int i = 0; i < population.length; i++)
            population[i] = new Individual_Grid(7);
        calcFitness();
        finished = false;
        generations = 0;
        perfectScore = 1;
    }

    void calcFitness() { for (Individual_Grid i : population) i.fitness(target); }


    String getBest() {
        double currentMax = 0;
        int iMax = 0;
        for (int i = 0; i < population.length; i++) {
            if (population[i].fitness > currentMax) {
                iMax = i;
                currentMax = population[i].fitness;
            }
        }

        if (currentMax == perfectScore ) finished = true;
        return population[iMax].getGrid();
    }

    boolean finished() { return finished; }

    public void setPopulation(Individual_Grid[] newPopulation) {
        population = newPopulation;
    }
}
