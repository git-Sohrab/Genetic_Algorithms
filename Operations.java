import java.util.ArrayList;
import java.util.Random;

class Operations {
    private Population population;
    private ArrayList<Individual> matingPool;
    private double mutationRate;
    private Random r;

    Operations(Population p, double m){
        population = p;
        r = new Random();
        mutationRate = m;
        matingPool = new ArrayList<>();
    }


    Population selection() {
        matingPool.clear();

        double maxFitness = 0;
        for (Individual i : population.individuals)
            if (i.fitness > maxFitness)
                maxFitness = i.fitness;

        for (Individual i : population.individuals) {
            double fitness = (i.fitness / maxFitness);
            int n = (int) fitness * 100;
            for (int j = 0; j < n; j++)
                matingPool.add(i);
        }
        return generateNextPopulation();
    }

    private Population generateNextPopulation() {
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

    private Individual crossover(Individual partnerA, Individual partnerB) {
        Individual child = new Individual(Individual.SIZE);
        int cPoint = r.nextInt(Individual.SIZE);

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
