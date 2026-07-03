package CompetitiveProgrammingSolutions;


//Problem statement: Rotate an nxn matrix by 90 degrees

class RotateNxNMatrix {
    public void rotate(int[][] matrix) {
        //Note: matrices rotate in the following fashion
        //The elements from the bottom row become the first column
        //Which is to say index 2 of the first index from the 2D indices' pair
        //becomes index 0 of the second index from the 2D indices pair
        //The pattern consists of the first dimension getting reduced by one starting from length -1
        // and then taking its second dimension elements and making them index zero of each first index dimension // then length - 2 and making them index one of each row until we reach zero so we have one pointer for indices starting at length - 1 and another for indices starting at 0 moving towards each other
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];
        int newSlotIndex = 0;
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = 0; j < matrix.length; j++){
                rotatedMatrix[j][newSlotIndex] = matrix[i][j];
            }
            newSlotIndex++;
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                matrix[i][j] = rotatedMatrix[i][j];
            }
        }
        matrix = rotatedMatrix;
    }
}