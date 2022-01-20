import javax.swing.JOptionPane;

//Grace Herbert

public class Battleship3 {

        //inputs
        private int rows;
        private int cols;
        private String[][] array;
        int playersChoice;
        private int compsNum;
        private int usersGuess;
        private int compGuess;
        private int nine = 0;
        private int playerScore = 0;
        private int compScore = 0;
        private boolean win;
        private String winner;

        //constructor
        public Battleship3(){
            this.rows = 3;
            this.cols = 3;
            this.playersChoice = 0;
            this.compsNum = 0;
            this.usersGuess = 0;
            this.compGuess = 0;
        }

        //setters and getters for rows and cols
        public void setRows(int rows){
            this.rows = rows;
        }

        public int getRows(){
            return this.rows;
        }

        public void setCols(int cols){
            this.cols = cols;
        }

        public int getCols(){
            return this.cols;
        }

        //instantiate array
        public String[][] instArray(int rows, int cols) {
            return this.array = new String[rows][cols];
        }

        //populate array with nums to 9 and bring var nine back to 0 before loop breaks
        public String[][] populateArray(String[][] array) {
            for(int i = 0; i < array.length; i++) {
                for(int j = 0; j < array.length; j++){
                    nine += 1;
                    array[i][j] = String.valueOf((nine));
                    if(nine == 9){
                        nine = 0;
                    }
                }
            }return array;
        }

        //getters and setters for usersGuess (Where is the comps ship?)
        public int getUsersGuess() {
            return usersGuess;
        }

        public void setUsersGuess() {
            int guess = Integer.parseInt(JOptionPane.showInputDialog(null, "Where is the Computers ship? \nWhere will you shoot? \nPlease pick a number 1-9"));
            if (guess > 0 && guess < 10) {
                this.usersGuess = guess;
            } else {
                JOptionPane.showInputDialog(null, "Please enter a number 1-9");
            }
        }

    //getters and setters for playerChoice (Where to set the ship?)
        public void setPlayersChoice() {
            playersChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Please pick the number relating to where you would like to place your ship on the grid.  \n Top-Left = 1, Top-Centre = 2, Top-Right = 3 \n Centre-Left = 4, Centre = 5, Centre-Right = 6\n Bottom-Left = 7, Bottom-Centre = 8, Bottom-Right = 9"));
        }

        public int getPlayersChoice() {
            return this.playersChoice;
        }

        //put ship in array
        public String[][] setShipLocation(String[][] array, int playersChoice) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (playersChoice == Integer.parseInt(array[i][j])) {
                        array[i][j] = "Ship";

                    }
                }
            }
            return array;
        }

        //for coding the app to check array
        public void checkElementsOfArray(String[][] array) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    System.out.println(array[i][j]);
                }
            }
        }

        //setters and getters compsNum (where will the comp place its ship?)
        public void setCompsNum() {
            compsNum = (int) ((Math.random() * 9) + 1);
        }

        public int getCompsNum() {
            System.out.println(compsNum);
            return this.compsNum;
        }

        //setters and getters for the comps random no to guess the Players ship location
        public void setCompGuess() {
            this.compGuess = (int) ((Math.random() * 9) + 1);
        }

        public int getCompGuess() {
            return compGuess;
        }

    //check if the ship is at the guessed location
    public String checkGuess(String[][] array, int guess) {
        nine = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                nine++;
                if (guess == nine){
                    if ((array[i][j]).equalsIgnoreCase("ship")){
                        win = true;
                        return "It's a hit! You sunk my Battleship! The Ship was at location: " + guess;
                    }else {
                        win = false;
                    return "Missed!!!";
                }

            }
        }

    }return "";
}
    //display location on ship (playersChoice/compsnum)
    public void displayLocation(int location){
        JOptionPane.showMessageDialog(null, "The Ship was at location: " + location);
    }

    //getter for win boolean
    public boolean getWin() {
        return this.win;
    }

    //display result
    public void displayResult(String result){
        JOptionPane.showMessageDialog(null, result);
    }


    //update score
    public int updateScore(boolean win){
                    if (win == true){
                    return 1;
                    }return 0;

                }

    //Who won?
    public void totalScore(int playerScore, int compScore){
            if (playerScore > compScore){
                winner = "Player Wins!";
                JOptionPane.showMessageDialog(null, "You win!!! You have beaten the System! You sunk my Battleships! You sunk: " + playerScore + ", the computer sunk: " + compScore);
            }else if (playerScore < compScore){
                winner = "Computer Wins!";
                JOptionPane.showMessageDialog(null, "You lose!!! Computer won this one! I sunk your Battleships! You sunk: " + playerScore + ", the computer sunk: " + compScore);
            }else{
                winner = "Everybody Wins/Everybody Loses!";
                JOptionPane.showMessageDialog(null, "It's a tie!!! Sure aren't we both great at sinking each other's Battleships?! You sunk: " + playerScore + ", the computer sunk: " + compScore);
            }
        }

}








