class Population {
    Individual[] individuals;
    int SIZE;
    private String target;
    int generations;
    private boolean finished;
    private int perfectScore;

    Population(String t, int individualsSize) {
        target = t;
        individuals = new Individual[SIZE = individualsSize];
        for (int i = 0; i < individuals.length; i++)
            individuals[i] = new Individual(target.length());
        calcFitness();
        finished = false;
        generations = 0;
        perfectScore = 1;
    }

    void calcFitness() { for (Individual i : individuals) i.fitness(target); }

    String getBest() {
        double currentMax = 0;
        int iMax = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].fitness > currentMax) {
                iMax = i;
                currentMax = individuals[i].fitness;
            }
        }
        if (currentMax == perfectScore ) finished = true;
        return individuals[iMax].getPhrase();
    }

    boolean finished() { return finished; }

    void setPopulation(Individual[] newPopulation) { individuals = newPopulation; }

    public Individual[] getIndividuals() { return individuals.clone(); }
}