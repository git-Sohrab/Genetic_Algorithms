import java.util.ArrayList;
import java.util.Random;

class Operations {
    private Population population;
    //private ArrayList<Individual> matingPool;
    private ArrayList<Individual> matingPool;
    private double mutationRate;
    private Random r;

    Operations(Population p, double m){
        population = p;
        r = new Random();
        mutationRate = m;
        matingPool = new ArrayList<>();
    }


    // Generate a mating pool
    Population selection() {
        // Clear the ArrayList
        matingPool.clear();

        double maxFitness = 0;
        for (Individual i : population.population)
            if (i.fitness > maxFitness)
                maxFitness = i.fitness;


        // Based on fitness, each member will get added to the mating pool a certain number of times
        // a higher fitness = more entries to mating pool = more likely to be picked as a parent
        // a lower fitness = fewer entries to mating pool = less likely to be picked as a parent
        for (Individual i : population.population) {
            double fitness = (i.fitness / maxFitness);
            int n = (int) fitness * 100;  // Arbitrary multiplier, we can also use monte carlo method
            for (int j = 0; j < n; j++)               // and pick two random numbers
                matingPool.add(i);
        }

        // New generation
        Individual[] newPopulation = new Individual[population.SIZE];
        for (int i = 0; i < population.SIZE; i++) {
            int a = r.nextInt(matingPool.size());
            int b = r.nextInt(matingPool.size());
            Individual partnerA = matingPool.get(a);
            Individual partnerB = matingPool.get(b);
            Individual child = crossover(partnerA, partnerB);
            mutate(child);
            newPopulation[i] = child;
        }

        population.setPopulation(newPopulation);
        population.calcFitness();
        population.generations++;
        return population;
    }

    // Crossover
    private Individual crossover(Individual partnerA, Individual partnerB) {
        // A new child
        Individual child = new Individual(Individual.SIZE);

        int cPoint = r.nextInt(Individual.SIZE); // Pick a midpoint

        // Half from one, half from the other
        for (int i = 0; i < Individual.SIZE; i++) {
            if (i > cPoint) child.genes[i] = partnerA.genes[i];
            else              child.genes[i] = partnerB.genes[i];
        }
        return child;
    }

    // Bit-flip mutation
    private void mutate(Individual i) {
        if (r.nextDouble() < mutationRate)
            i.genes[r.nextInt(Individual.SIZE)] = i.alphabet[r.nextInt(i.alphabet.length)];
    }
}
