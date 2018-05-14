import java.util.Random;

public class Individual_Grid {
    char[] alphabet = {'1','0'};
    // The genetic sequence
    char[][] genes;
    static int SIZE;
    double fitness;

    // Constructor (makes a r.nextInt() Individual)
    Individual_Grid(int size) {
        SIZE = size;
        genes = new char[SIZE][SIZE];
        Random r = new Random();
        for (int i = 0; i < genes.length; ++i) {
            for (int j = 0; j < genes[i].length; ++j)
                genes[i][j] = alphabet[r.nextInt(alphabet.length)];  // Pick from range of chars
        }
    }

    // Converts character array to a String
    String getGrid() {
        StringBuilder output = new StringBuilder();
        for (char[] gene : genes) {
            for (char aGene : gene) output.append(aGene);
            output.append("\n");
        }
        return output.toString();
    }

    // Fitness function (returns double point % of "correct" characters)
    void fitness (String target) {
        int score = 0;
        for (int i = 0; i < genes.length; i++)
            for (int j = 0; j < genes[i].length; ++j)
                if (genes[i][j] == target.charAt(i))
                    score++;

        fitness = (double)score / (double)target.length();
    }
}
