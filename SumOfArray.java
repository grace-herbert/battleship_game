import javax.swing.JOptionPane;

//Grace Herbert

public class SumOfArray {
    //2D array
    //inputs
    private int row = 3;
    private int column = 3;
    private int[][] sumArray = new int[row][column];
    private int sumRow1;
    private int avgRw1;
    private int sumRow2;
    private int avgRw2;
    private int sumRow3;
    private int avgRw3;
    private int sumCol1;
    private double avgCol1;
    private int sumCol2;
    private double avgCol2;
    private int sumCol3;
    private double avgCol3;
    private int sumTotalOfArray;
    private double avgArr;
    private int count;

    //populate array
    public void populateArray() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sumArray[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, (i + 1) + "." + (j + 1) + " Please enter a Number: "));
            }
        }
    }

    //get avg per row
    public void getAverage() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sumTotalOfArray += sumArray[i][j];
                count++;
                if (i == 0) {
                    sumRow1 += sumArray[i][j];
                } else if (i == 1) {
                    sumRow2 += sumArray[i][j];
                } else {
                    sumRow3 += sumArray[i][j];
                }
                if (j == 0) {
                    sumCol1 += sumArray[i][j];
                } else if (j == 1) {
                    sumCol2 += sumArray[i][j];
                } else {
                    sumCol3 += sumArray[i][j];
                }

            }

        }
        //calculate averages
        //avg row 1
        avgRw1 = sumRow1 / sumArray.length;
        //avg row 2
        avgRw2 = sumRow2 / sumArray.length;
        //avg row 3
        avgRw3 = sumRow3 / sumArray.length;
        //avg row 1
        avgCol1 = sumCol1 / sumArray.length;
        //avg row 2
        avgCol2 = sumCol2 / sumArray.length;
        //avg row 3
        avgCol3 = sumCol3 / sumArray.length;
        //avg of array
        avgArr = sumTotalOfArray / count;
    }

    public void displayAverages() {
        JOptionPane.showMessageDialog(null, "Average of Row #1 is: " + avgRw1 + "\nAverage of Row #2 is: " + avgRw2 + "\nAverage of Row #3 is: " + avgRw3);
        JOptionPane.showMessageDialog(null, "Average of Column #1 is: " + avgCol1 + "\nAverage of Column #2 is: " + avgCol2 + "\nAverage of Column #3 is: " + avgCol3);
        JOptionPane.showMessageDialog(null, "Average of Total Array is: " + avgArr);
    }
}