package se.lnu.Exercise6;

public class TimeMeasuring {

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {

            StringBuilder str = new StringBuilder();
            long start = System.currentTimeMillis();
            System.out.println(System.currentTimeMillis() - start < 1000);
            while (System.currentTimeMillis() - start < 1000) {
                str.append("#####");
            }
            long end = System.currentTimeMillis();
            int runTime = (int) (end - start);

            long begin = System.currentTimeMillis();
            str.toString();
            long finish = System.currentTimeMillis();
            int toStringTime = (int) (finish - begin);

            StringBuilder newBuilder = new StringBuilder();
            long startPoint = System.currentTimeMillis();
            while (System.currentTimeMillis() - startPoint < 1000 - toStringTime) {
                newBuilder.append("#####");
            }
            long endPoint = System.currentTimeMillis();
            int newRunTime = (int) (endPoint - startPoint);

            System.out.println("Before ToString:  Approximate time: " + runTime + " milliseconds."
                    + " Total concatenations: " + str.length() + ".  Total length: " + str.length());
            System.out.println("ToString time: " + toStringTime + " milliseconds.");
            System.out.println("After ToString:  Approximate time: " + (newRunTime + toStringTime)
                    + " milliseconds.  Total concatenation: " + (newBuilder.length() / 80) + ".  Total Length: "
                    + newBuilder.length() + "\n");
        }

    }
}