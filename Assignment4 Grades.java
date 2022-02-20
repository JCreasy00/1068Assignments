import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        System.out.println("This program accepts your homework and two exam scores as input and computes your grade in the course.");

        // getting the weights of assignments and displaying them
        Scanner forReply = new Scanner(System.in);
        System.out.print("Homework weight?: ");
        int hwWeight = forReply.nextInt();
        System.out.print("Exam one weight?: ");
        int ex1Weight = forReply.nextInt();
        int ex2Weight = 100 - (hwWeight + ex1Weight);

        System.out.println(" ");
        System.out.println("Using weights of " + hwWeight + " " + ex1Weight + " " + ex2Weight);
        System.out.println(" ");

        // collecting data to calculate hw score
        System.out.print("Number of Assignments?: ");
        int numOfAssignments = forReply.nextInt();
        System.out.print("Average Homework Grade?: ");
        float avgHwGrade = forReply.nextFloat();
        System.out.print("Late Days Used?: ");
        int latesUsed = forReply.nextInt();
        System.out.print("Labs Attended?: ");
        int labsAttended = forReply.nextInt();
        System.out.println(" ");

        // calling our function that calculates the total points with the gathered information.
        float hwGrade = totalPointCalculation(numOfAssignments,
                avgHwGrade,
                latesUsed,
                labsAttended);

        //printing homework information
        float possiblePoints = numOfAssignments * (14); //10(Homeworks worth 10) + 4(labs worth 4)
        float weightedScore = (hwGrade / possiblePoints) * hwWeight; // Wighted scores are the (grade/possible grade)*weight
        System.out.println("HomeworkScore = " + hwGrade + "/" + possiblePoints);
        System.out.println("Weighted Score: " + weightedScore);
        System.out.println(" ");

        //Exam 1
        System.out.println("Exam 1: ");
        System.out.print("Score: ");
        float exam1Grade = forReply.nextFloat();
        System.out.print("Exam Curve: ");
        int exam1Curve = forReply.nextInt();

        float exam1WeightedScore = examGrader(exam1Grade, exam1Curve,ex1Weight);

        System.out.println("Weighted Score: " + exam1WeightedScore);
        System.out.println(" ");

        // Exam 2
        System.out.println("Exam 2: ");
        System.out.print("Score: ");
        float exam2Grade = forReply.nextFloat();
        System.out.print("Exam Curve: ");
        int exam2Curve = forReply.nextInt();

        float exam2WeightedScore = examGrader(exam2Grade, exam2Curve, ex2Weight);

        System.out.println("Weighted Score: " + exam2WeightedScore);
        System.out.println(" ");

        // Calling courseFinalGrade function that returns the final grade
        float courseFinalGrade = courseGradeCalculation(weightedScore, exam1WeightedScore, exam2WeightedScore);
        System.out.println("Course Grade: " + courseFinalGrade);
    }

    public static float totalPointCalculation(int numOfAssignments, float avgHwGrade,
                                              int lateUse, int labsAttended) {
        // limiting input for avgHwGrade
        if (avgHwGrade <= 0) {
            avgHwGrade = 0;
        } else if (avgHwGrade > 10) {
            avgHwGrade = 10;
        }

        //total points calculation
        float hwScore = (numOfAssignments * avgHwGrade) + (labsAttended * 4);
        float possiblePoints = numOfAssignments * (14); //10(Homeworks worth 10) + 4(labs worth 4)

        if (lateUse > numOfAssignments / 2) {
            hwScore *= .09;
        } else if (lateUse == 0) {
            hwScore += 5;
            if (hwScore > possiblePoints) {
                hwScore = possiblePoints;
            }
        }
        if (numOfAssignments <= 0) hwScore = possiblePoints;

        return (hwScore);
    }

    public static float courseGradeCalculation(float weightedScore,
                                               float exam1WeightedScore, float exam2WeightedScore) {
        float finalGrade = weightedScore + exam1WeightedScore + exam2WeightedScore;

        return (finalGrade);
    }

    public static float examGrader(float examGrade, int examCurve, int examWeight) {
        examGrade += examCurve;

        if (examGrade > 100) examGrade = 100;

        System.out.println("Exam Grade: " + examGrade + "/ 100");
        float examWeightedScore = examWeight * (examGrade / 100);

        return examWeightedScore;

    }
}















