package BaiTap.Day9;

public class TennisGame {

    public static String getScore(String playerName1, String playerName2,int matchScore1, int matchScore2) {
        String disPlay = "";
        if (matchScore1 == matchScore2) {
            switch (matchScore1) {
                case 0:
                    disPlay = "Begin";

                    break;
                case 1:
                    disPlay = "Fifteen-All";

                    break;
                case 2:
                    disPlay = "Thirty-All";

                    break;
                case 3:
                    disPlay = "Forty-All";

                    break;
                default:
                    disPlay = "Deuce";

                    break;

            }
        } else if (matchScore1 >= 4 || matchScore2 >= 4) {
            int minusResult = matchScore1 - matchScore2;
            if (minusResult == 1) {
                disPlay = "Advantage player1";
            } else if (minusResult == -1) {
                disPlay = "Advantage player2";
            } else if (minusResult >= 2) {
                disPlay = "Win for player1";
            } else {
                disPlay = "Win for player2";
            }
        } else {
            disPlay = getString(matchScore1, disPlay);
            disPlay += "-";
            disPlay = getString(matchScore2, disPlay);

        }
        return disPlay;
    }
    private static String getString(int matchScore1, String disPlay) {
        switch (matchScore1) {
            case 0:
                disPlay += "Love";
                break;
            case 1:
                disPlay += "Fifteen";
                break;
            case 2:
                disPlay += "Thirty";
                break;
            case 3:
                disPlay += "Forty";
                break;
        }
        return disPlay;
    }
}
