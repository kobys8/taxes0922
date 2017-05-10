/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package taxes0922;

/**
 *
 * @author kms080
 */
import javax.swing.JOptionPane;
public class Taxes0922 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        taxChecker taxes = new taxChecker(40, 7.25);
        taxes.taxCruncher();
        JOptionPane.showMessageDialog(null, taxes.toString());
        JOptionPane.showMessageDialog(null, taxes.getTaxInfo(40, 7.25));
    }
}

class taxChecker {
    private static int totalHours;
    private static double hoursEarnings;
    private static double statGrossPay;
    private static double federalTaxCrunch;
    private static double ficaTaxCrunch;
    private static double stateTaxCrunch;
    private static double statNetPay;
    private int myHours;
    private double myWage;
    private double grossPay;
    private double fedCrunch;
    private double ficaCrunch;
    private double stateCrunch;
    private double netPay;
    private static final double FEDTAX = .154;
    private static final double FICATAX = .0775;
    private static final double STATETAX = .040;
    public taxChecker(int hoursWorked, double hourlyWage) {
        myHours = hoursWorked;
        myWage = hourlyWage;
    }
    public static String getTaxInfo(int hoursWorked, double hourlyWage){
        totalHours = hoursWorked;
        hoursEarnings = hourlyWage;
        statGrossPay = totalHours * hoursEarnings;
        federalTaxCrunch = statGrossPay * FEDTAX;
        ficaTaxCrunch = statGrossPay * FICATAX;
        stateTaxCrunch = statGrossPay * STATETAX;
        statNetPay = statGrossPay - (ficaTaxCrunch + federalTaxCrunch + stateTaxCrunch);
        return "Static\n\nHours worked: " + totalHours + "\nHourly rate: " + hoursEarnings + "\n\nGross pay: " + statGrossPay + "\n\nFederal Tax (15.4%): " + federalTaxCrunch + "\nFICA Tax (7.75%): " + ficaTaxCrunch + "\nState Tax (4.0%): " + stateTaxCrunch + "\n\nNet pay: " + statNetPay;
    }
    public void taxCruncher() {
        grossPay = myHours * myWage;
        fedCrunch = grossPay * FEDTAX;
        ficaCrunch = grossPay * FICATAX;
        stateCrunch = grossPay * STATETAX;
        netPay = grossPay - (fedCrunch+ficaCrunch+stateCrunch);
    }
    public String toString() {
        return "Hours worked: " + myHours + "\nHourly rate: " + myWage + "\n\nGross pay: " + grossPay + "\n\nFederal Tax (15.4%): " + fedCrunch + "\nFICA Tax (7.75%): " + ficaCrunch + "\nState Tax (4.0%): " + stateCrunch + "\n\nNet pay: " + netPay;
    }
}
