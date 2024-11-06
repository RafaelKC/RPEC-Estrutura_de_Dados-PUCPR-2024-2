import Rkc.CodigoMorse;
import Rkc.Sorting.Sorting;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) throws IOException {
        var arr = new ArrayList<Integer>();

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int randomNumber = random.nextInt(2000000000);
            arr.add(randomNumber);
        }

        long startTime = System.nanoTime();
        var newArr = Sorting.InsertSort(arr);
        long endTime = System.nanoTime();
        long durationInsertion = endTime - startTime;

        startTime = System.nanoTime();
        var newArr2 = Sorting.BobbleSort(arr);
        endTime = System.nanoTime();
        long durationBobble = endTime - startTime;

        startTime = System.nanoTime();
        var newArr3 = Sorting.QuickSort(arr);
        endTime = System.nanoTime();
        long durationQuick = endTime - startTime;

        System.out.println(arr);
        System.out.println(newArr);
        System.out.println(TimeUnit.MILLISECONDS.convert(durationInsertion, TimeUnit.NANOSECONDS));
        System.out.println(newArr2);
        System.out.println(TimeUnit.MILLISECONDS.convert(durationBobble, TimeUnit.NANOSECONDS));
        System.out.println(newArr3);
        System.out.println(TimeUnit.MILLISECONDS.convert(durationQuick, TimeUnit.NANOSECONDS));
    }
}