import java.util.Scanner;

public class MovieCriticism {
    int score[][] = {
        {3, 1, 5, 2, 5},
        {4, 2, 1, 4, 2},
        {5, 3, 1, 2, 4},
        {2, 1, 5, 4, 4},
        {3, 3, 4, 3, 3}
    };

    public static void main(String[] args) {
        MovieCriticism movieCriticism = new MovieCriticism();
        movieCriticism.calculateAndPrintAverages();
        movieCriticism.findMostSimilarMovie();
    }

    public void calculateAndPrintAverages() {
        int numMovies = score[0].length;
        int numUsers = score.length;

        // Calculate movie averages
        System.out.println("Movie Average Score:");
        for (int movie = 0; movie < numMovies; movie++) {
            int movieSum = 0;
            for (int user = 0; user < numUsers; user++) {
                movieSum += score[user][movie];
            }
            double movieAvg = (double) movieSum / numUsers;
            System.out.println("Movie " + (movie + 100) + ": " + movieAvg);
        }

        // Calculate user averages
        System.out.println("User Average Score:");
        for (int user = 0; user < numUsers; user++) {
            int userSum = 0;
            for (int movie = 0; movie < numMovies; movie++) {
                userSum += score[user][movie];
            }
            double userAvg = (double) userSum / numMovies;
            System.out.println("User " + (user + 1) + ": " + userAvg);
        }
    }

    public void findMostSimilarMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a movie number (100-104): ");
        int op = scanner.nextInt();

        if (op < 100 || op > 104) {
            System.out.println("Invalid movie number. Please Retype.\n");
        }

        int inputMovieIndex = op - 100;
        int numMovies = score.length;

        int mostSimilarMovie = -1;
        double minCartesianDistance = Double.MAX_VALUE;

        for (int movie = 0; movie < numMovies; movie++) {
            if (movie != inputMovieIndex) {
                double distance = CalculateCD(inputMovieIndex, movie);
                if (distance < minCartesianDistance) {
                    minCartesianDistance = distance;
                    mostSimilarMovie = movie;
                }
            }
        }

        System.out.println("The most similar movie to Movie " + op + " is Movie " + (mostSimilarMovie + 100));
        System.out.println("Cartesian Distance: " + minCartesianDistance);
    }

    private double CalculateCD(int movie1, int movie2) {
        int numUsers = score[0].length;
        double distance = 0;

        for (int user = 0; user < numUsers; user++) {
            int diff = score[user][movie1] - score[user][movie2];
            distance += diff * diff;
        }

        return Math.sqrt(distance);
    }
}
