class Population {
    Individual[] population;             // Array to hold the current population
    int SIZE;
    private String target;                // Target phrase
    int generations;              // Number of generations
    private boolean finished;             // Are we finished evolving?
    private int perfectScore;

    Population(String p, int populationSize) {
        target = p;
        population = new Individual[populationSize];
        SIZE = populationSize;
        for (int i = 0; i < population.length; i++)
            population[i] = new Individual(target.length());
        calcFitness();
        finished = false;
        generations = 0;
        perfectScore = 1;
    }

    // Fill our fitness array with a value for every member of the population
    void calcFitness() { for (Individual i : population) i.fitness(target); }

    // Compute the current "most fit" member of the population
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
        return population[iMax].getPhrase();
    }

    boolean finished() { return finished; }

    void setPopulation(Individual[] newPopulation) { population = newPopulation; }
}