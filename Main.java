public class Main {

    public static void main(String[] args) {
        //String target = "0001000000100011111110001000000100000010000001000";
        String target = "000000000010000000000" +
                        "000000000111000000000" +
                        "000000001111100000000" +
                        "000000010111010000000" +
                        "000000100111001000000" +
                        "000001000111000100000" +
                        "000010000111000010000" +
                        "000100000111000001000" +
                        "001000000111000000100" +
                        "010000000111000000010" +
                        "111111111111111111111" +
                        "010000000111000000010" +
                        "001000000111000000100" +
                        "000100000111000001000" +
                        "000010000111000010000" +
                        "000001000111000100000" +
                        "000000100111001000000" +
                        "000000010111010000000" +
                        "000000001111100000000" +
                        "000000000111000000000" +
                        "000000000010000000000" ;
        //char[][] target =  {{'0','0','1','0','0'},{'0','0','1','0','0'},{'1','1','1','1','1'},{'0','0','1','0','0'},{'0','0','1','0','0'},{'0','0','1','0','0'}};
        int maxPopulation = 1000;
        double mutationRate = 0.05;

        Population population = new Population(target, maxPopulation);

        Operations operation = new Operations(population, mutationRate);

        boolean t = true;
        while (t) {
            population = operation.selection();
            System.out.println("Best phrase: " + "\n" + population.getBest());
            if (population.finished())
                t = false;
        }
        System.out.println("Total generations: " + population.generations);

    }
}

