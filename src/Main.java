import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        readFile("poem.txt", queue);
        printQueueWithRandomDelay(queue);
    }

    private static void readFile(String filename, Queue<String> queue) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                queue.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printQueueWithRandomDelay(Queue<String> queue) {
        Random random = new Random();
        while (!queue.isEmpty()) {
            String line = queue.poll();
            System.out.println(line);
            try {
                Thread.sleep((random.nextInt(3) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}