package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Patient p = new Patient();
        p.dayArray = new int[]{};
        p.peakFlowArray = new int[]{};
        int i = 0;


        final int peakFlow = inputInt("What has the doctor given as being a dangerous reading");
        int day = inputInt("Choose a day of the month (1-31)");


        while (day != 0 && i < 31)
        {
            p.dayArray[i] = day;
            int reading1 = inputInt("What is the first reading for the day?");
            int reading2 = inputInt("What is the second reading for the day?");
            int reading3 = inputInt("What is the third reading for the day?");
            p.peakFlowArray = storeReadings(reading1, reading2, reading3, p.peakFlowArray, i);

            checkReading(peakFlow, p.peakFlowArray[i]);
            i++;

            day = inputInt("Choose a day of the month (1-31)");
        }

        for (int j = 0; j < i; j++) {
            print(getDay(p, j) + " , " + getPeakFlow(p, j));
        }

    }

    public static int[] storeReadings(int reading1, int reading2, int reading3, int[] readingArray, int i)
    {
        int peakReading = Math.max(reading1, reading2);
        peakReading = Math.max(peakReading, reading3);

        readingArray[i] = peakReading;
        return readingArray;
    }
    public static void checkReading(int peakFlow, int reading)
    {
        if (reading < peakFlow)
        {
            print("Worryingly low");
        }

    }
    public static void print(String m)
    {
        System.out.println(m);
    }

    public static String inputString(String m)
    {
        String answer;
        Scanner scanner = new Scanner(System.in);
        print(m);
        answer = scanner.nextLine();

        return answer;
    }

    public static int inputInt(String m)
    {
        int answer;
        Scanner scanner = new Scanner(System.in);
        print(m);
        answer = scanner.nextInt();

        return answer;
    }

    public static int getDay(Patient p, int i)
    {
        return p.dayArray[i];
    }

    public static int getPeakFlow(Patient p, int i)
    {
        return p.peakFlowArray[i];
    }
}

class Patient{
    int[] dayArray;
    int[] peakFlowArray;

}