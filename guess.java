import java.util.Random;
import javax.swing.JOptionPane;

class n {
    public static void main(String[] args) {
        int a = 1;
        int b = 100;
        int totalAttempts = 7;
        int pts = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int num = randomNumber(a, b);
            int attempts = 0;
            
            JOptionPane.showMessageDialog(null, "Welcome to Number Guessing Game!");
            JOptionPane.showMessageDialog(null, "Here you go!");
            while (true) {
                String guessValue = JOptionPane.showInputDialog("Guess a number between " + a + " and " + b + ":");
                if (guessValue == null) 
                {
                    JOptionPane.showMessageDialog(null, "Game over!");
                    playAgain = false;
                    break;
                }
                
                int guess = Integer.parseInt(guessValue);
                attempts++;
                
                if (guess == num) {
                    int points = totalAttempts - attempts + 10;
                    pts += points;
                    JOptionPane.showMessageDialog(null, "Congratulations! You got the correct answer!\nAttempts: " + attempts + "\nPoints earned: " + points + "\nTotal points: " + pts);
                    break;
                } else if (guess < num) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again");
                }
                
                if (attempts >= totalAttempts) {
                    JOptionPane.showMessageDialog(null, "Game over! You have reached the max number of attempts.\nThe correct number is: " + num);
                    break;
                }
            }
            
            int option = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "play again", JOptionPane.YES_NO_OPTION);
            
            if (option == JOptionPane.NO_OPTION) {
                playAgain = false;
            }
        }
    }
    
    public static int randomNumber(int a, int b) {
        Random r = new Random();
        return r.nextInt(b - a + 1) + a;
    }
}