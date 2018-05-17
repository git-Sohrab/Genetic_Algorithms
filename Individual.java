import java.util.Random;

class Individual {
    char[] alphabet = {'0','1'};
    char[] genes;
    static int SIZE;
    double fitness;

    Individual(int size) {
        SIZE = size;
        genes = new char[SIZE];
        Random r = new Random();
        for (int i = 0; i < genes.length; i++) {
            genes[i] = alphabet[r.nextInt(alphabet.length)];
        }
    }

    String getPhrase() {
        StringBuilder output = new StringBuilder();
        for (int j = 1; j <= SIZE; ++j) {
            output.append(genes[j-1]);
            if (j >= 21 && j%21 == 0)   // 21 is the length of the row
                output.append("\n");
        }
        return output.toString();
    }

    void fitness (String target) {
        int score = 0;
        for (int i = 0; i < genes.length; i++)
            if (genes[i] == target.charAt(i))
                score++;
        fitness = (double)score / (double)target.length();
    }
}
