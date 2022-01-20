import javax.swing.JOptionPane;

//Grace Herbert

public class Battleship3App {

    public static void main(String[] args) {
        //inputs
        int rows;
        int cols;
        int compNum;
        String[][] playerArr;
        String[][] compArr;
        int playersChoice;
        int usersGuess;
        int compGuess;
        String result;
        int playerScore = 0;
        int compScore = 0;
        boolean win = false;
        String winner = " ";

        //welcome msg

        JOptionPane.showMessageDialog(null,"Welcome to Battleship!");

        //get instance of Battleship3
        Battleship3 btl = new Battleship3();
        // run game three times
        do{
            //get no. of cols and rows
            rows = btl.getRows();
            cols = btl.getCols();

            //instantiate and populate player array
            playerArr = btl.instArray(rows,cols);
            playerArr = btl.populateArray(playerArr);

            //instantiate and populate comparr
            compArr = btl.instArray(rows,cols);
            compArr = btl.populateArray(compArr);

            //get and set location of players ship
            btl.setPlayersChoice();
            playersChoice = btl.getPlayersChoice();
            playerArr = btl.setShipLocation(playerArr, playersChoice);

            //get and set location of comps ship
            btl.setCompsNum();
            compNum = btl.getCompsNum();
            compArr = btl.setShipLocation(compArr, compNum);
            JOptionPane.showMessageDialog(null,"The computer has chosen where to set it's ship.");

            //get and set users guess
            btl.setUsersGuess();
            usersGuess = btl.getUsersGuess();

            //Check result

            //Try shoot comps ship and update score
            result = btl.checkGuess(compArr, usersGuess);
            btl.displayResult(result);
            win = btl.getWin();
            playerScore += btl.updateScore(win);
            if(win == false){
                btl.displayLocation(compNum);
            }

            //Get and set comp guess
            btl.setCompGuess();
            compGuess = btl.getCompGuess();
            JOptionPane.showMessageDialog(null,"The computer has chosen where to shoot.");


            //Comp tries to shoot players ship
            result = btl.checkGuess(playerArr, compGuess);
            btl.displayResult(result);
            win = btl.getWin();
            compScore += btl.updateScore(win);
            if(win == false){
                System.out.println("The computer shoot's at location: " + compGuess);
                btl.displayLocation(playersChoice);
            }


        }while (playerScore < 1 && compScore < 1);



        //who won?!!!
        btl.totalScore(playerScore,compScore);
    }//main



}//class




