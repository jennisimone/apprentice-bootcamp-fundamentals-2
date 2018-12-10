package bowling;

class Bowling {
    private int totalScore = 0;

    Bowling() {
    }

    int getScore() {
        return totalScore;
    }

    int gameScores(int[][]rolls) {
        for(int[] eachTurn : rolls){
            for(int eachRoll : eachTurn)
            totalScore += eachRoll;
        }
        return totalScore;
    }

}

