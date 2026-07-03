package CompetitiveProgrammingSolutions;

public class TreeHeightDaysCount {
    public static int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int currentHeight = 0;
        int daysCount = 0;
        while(currentHeight < desiredHeight){
            currentHeight += upSpeed;
            if(currentHeight >= desiredHeight){
                daysCount++;
                break;
            }
            currentHeight -= downSpeed;
            daysCount++;
        }
        return daysCount;
    }
}