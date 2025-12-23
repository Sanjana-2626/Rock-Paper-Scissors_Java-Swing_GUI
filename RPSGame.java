import javax.swing.*;

public class RPSGame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Rock Paper Scissors");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel resultLabel = new JLabel("Make your move");
        resultLabel.setBounds(120, 30, 250, 30);

        JButton rockBtn = new JButton("Rock");
        rockBtn.setBounds(50, 100, 90, 30);

        JButton paperBtn = new JButton("Paper");
        paperBtn.setBounds(150, 100, 90, 30);

        JButton scissorsBtn = new JButton("Scissors");
        scissorsBtn.setBounds(250, 100, 90, 30);

        rockBtn.addActionListener(e -> playGame("Rock", resultLabel));
        paperBtn.addActionListener(e -> playGame("Paper", resultLabel));
        scissorsBtn.addActionListener(e -> playGame("Scissors", resultLabel));

        frame.add(resultLabel);
        frame.add(rockBtn);
        frame.add(paperBtn);
        frame.add(scissorsBtn);

        frame.setVisible(true);
    }

    static void playGame(String userChoice, JLabel label) {

        String[] choices = {"Rock", "Paper", "Scissors"};
        int randomIndex = (int) (Math.random() * 3);
        String computerChoice = choices[randomIndex];

        String result;

        if (userChoice.equals(computerChoice)) {
            result = "Draw!";
        } else if (
                (userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (userChoice.equals("Scissors") && computerChoice.equals("Paper"))
        ) {
            result = "You Win!";
        } else {
            result = "You Lose!";
        }

        label.setText("Computer: " + computerChoice + " | " + result);
    }
}
