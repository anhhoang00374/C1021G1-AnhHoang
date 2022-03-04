package code_gym.cleanCode_refactoring.exercise;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1Score, int play2Score2) {
        String score = "";
        int tempScore=0;
        if (player1Score==play2Score2)
        {
            score = compareSore(player1Score);
        }
        else if (player1Score>=4 || play2Score2>=4)
        {
            score = score(player1Score, play2Score2);
        }
        else
        {
            score = compareTempScore(player1Score, play2Score2, score);
        }
        return score;
    }

    private static String compareTempScore(int player1Score, int play2Score2, String score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = player1Score;
            else { score +="-"; tempScore = play2Score2;}
            switch(tempScore)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    private static String score(int player1Score, int play2Score2) {
        String score;
        int minusResult = player1Score - play2Score2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private static String compareSore(int player1Score) {
        String score;
        switch (player1Score)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
