import java.util.Scanner;

public class Report {
   public static void main (String[] args) {
      Scanner in = new Scanner(System.in);

      double cp = 4.18;
      int ccal = 22;
      int reaction = 1;
      int mass = 50;
      while (in.hasNextLine()) {
         double initialT = in.nextDouble();
         double finalT = in.nextDouble();
         double changeInT = finalT - initialT;
         double qsoln = cp * mass * changeInT / 1000;
         double qcal = ccal * changeInT / 1000;
         double qrxn = -1 * (qcal + qsoln);
         double hrxn = qrxn;

         // ------------------------------------

         double initialT2 = in.nextDouble();
         double finalT2 = in.nextDouble();
         double changeInT2 = finalT2 - initialT2;
         double qsoln2 = cp * mass * changeInT2 / 1000;
         double qcal2 = ccal * changeInT2 / 1000;
         double qrxn2 = -1 * (qcal2 + qsoln2);
         double hrxn2 = qrxn2;

         double average = (qrxn + qrxn2) /2;

         System.out.printf("Reaction %d:%nqsoln = cp * mass * (finalt - initialT) / 1000 = %.4f * %d * %.4f / 1000 = %.4fkJ%nqcal = Ccal * chanceInT / 1000 = %d * %.4f / 1000 = %.4fkJ %nqrxn = -(qcal +qsoln) = -(%.4f + %.4f) = %.4fkJ %nhrxn = qrxn = %.4fkJ%n", reaction, cp, mass, changeInT, qsoln, ccal, changeInT, qcal,
                           qcal, qsoln, qrxn, qrxn);
         System.out.printf("%nqsoln = cp * mass * (finalt - initialT) / 1000 = %.4f * %d * %.4f / 1000 = %.4fkJ%nqcal = Ccal * chanceInT / 1000 = %d * %.4f / 1000 = %.4fkJ %nqrxn = -(qcal +qsoln) = -(%.4f + %.4f) = %.4fkJ %nhrxn = qrxn = %.4fkJ%n", cp, mass, changeInT2, qsoln2, ccal, changeInT2, qcal2,
                           qcal2, qsoln2, qrxn2, qrxn2);
         System.out.printf("%nAverage = (trial1 + trial2) /2 = (%.4f + %.4f) /2 = %.4fkJ%n", qrxn, qrxn2, average);
         if (qrxn > 0) System.out.printf("Endothermic%n%n");
         else System.out.printf("Exothermic%n%n");
         reaction++;
      }
   }
}