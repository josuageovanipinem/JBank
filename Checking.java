
/**
 * Class abstract Checking referensi ke LineOfCredit dan OverdraftProtection
 * 
 * @Josua Geovani Pinem
 * @version 27/03/2016
 */
public abstract class Checking extends Account
{
    // instance variables - replace the example below with your own
    protected double monthlyFee;
    
    /**
     * Metode abstrak cek bayaran akun Checking
     * @return void
     */
    protected abstract void feeAssessment();

    /**
     * Metode abstrak reset biaya akun bulanan
     * @return void
     */
    public void resetMonthlyFee() {
        monthlyFee = 0;
    }

    /**
     * Metode getter abstrak  biaya akun bulanan
     * @return monthlyfee      biaya bulanan
     */
    public double getMonthlyFee() {
        return monthlyFee;
    }
}
