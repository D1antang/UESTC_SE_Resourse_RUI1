package homework1;
import java.util.Scanner;

public class ClassScore {
    public static void main(String[] args) {
        System.out.println("姓名：詹锐艺");
        System.out.println("学号：2021090920004");

        int numClasses = 3;  // 班级数
        double[][] scores = new double[numClasses][];  // 成绩数组

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numClasses; i++) {
            try {
                System.out.printf("输入第%d个班级的成绩：\n", i + 1);
                scores[i] = readScores(scanner);
                double avgScore = computeAvgScore(scores[i]);
                System.out.printf("第%d个班级的平均成绩为%.2f。\n", i + 1, avgScore);
            } catch (InvalidScoreException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("完成输入和计算。");
            }
        }

        double totalAvgScore = computeAvgScore(scores);
        System.out.printf("所有班级的平均成绩为%.2f。\n", totalAvgScore);
    }

    /**
     * 读取一个班级的成绩。
     * 如果输入的成绩非法，抛出 InvalidScoreException。
     */
    private static double[] readScores(Scanner scanner) throws InvalidScoreException {
        System.out.println("输入成绩（每个成绩占一行，输入 -1 结束）：");
        double[] scores = new double[100];  // 最多支持 100 个成绩
        int numScores = 0;

        while (true) {
            double score = scanner.nextDouble();

            if (score < 0) {
                break;
            } else if (score < 0 || score > 100) {
                throw new InvalidScoreException("非法成绩：" + score);
            }

            scores[numScores] = score;
            numScores++;
        }

        double[] trimmedScores = new double[numScores];
        System.arraycopy(scores, 0, trimmedScores, 0, numScores);
        return trimmedScores;
    }

    /**
     * 计算一个班级的平均成绩。
     */
    private static double computeAvgScore(double[] scores) {
        if (scores.length == 0) {
            return 0;
        }

        double sum = 0;
        for (double score : scores) {
            sum += score;
        }

        return sum / scores.length;
    }

    /**
     * 计算多个班级的平均成绩。
     */
    private static double computeAvgScore(double[][] scores) {
        if (scores.length == 0) {
            return 0;
        }

        double sum = 0;
        int numScores = 0;
        for (double[] classScores : scores) {
            for (double score : classScores) {
                sum += score;
                numScores++;
            }
        }

        return sum / numScores;
    }

    /**
     * 自定义异常类，用于表示非法成绩。
     */
    private static class InvalidScoreException extends Exception {
        public InvalidScoreException(String message) {
            super(message);
        }
    }
}
