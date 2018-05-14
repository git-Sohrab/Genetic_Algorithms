import java.util.Random;

class Individual {
//    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
//            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' ',',','.','?','!'};
    char[] alphabet = {'0','1'};
    // The genetic sequence
    char[] genes;
    static int SIZE;
    double fitness;

    // Constructor (makes a r.nextInt() Individual)
    Individual(int size) {
        SIZE = size;
        genes = new char[SIZE];
        Random r = new Random();
        for (int i = 0; i < genes.length; i++) {
            genes[i] = alphabet[r.nextInt(alphabet.length)];  // Pick from range of chars
        }
    }

    // Converts character array to a String
    String getPhrase() {
        StringBuilder output = new StringBuilder();
        for (int j = 1; j <= SIZE; ++j) {
            output.append(genes[j-1]);
            if (j >= 21 && j%21 == 0)
                output.append("\n");
        }

        return output.toString();
    }

    // Fitness function (returns double point % of "correct" characters)
    void fitness (String target) {
        int score = 0;
        for (int i = 0; i < genes.length; i++) {
            if (genes[i] == target.charAt(i)) {
                score++;
            }
        }
        fitness = (double)score / (double)target.length();
    }
}
