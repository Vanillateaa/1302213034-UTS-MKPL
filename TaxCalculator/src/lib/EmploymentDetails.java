package lib;
import java.time.LocalDate;
public class EmploymentDetails {
    private static final int[] SALARY_GRADES = {3000000, 5000000, 7000000};
    // * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya 
    private static final double FOREIGNER_SALARY_MULTIPLIER = 1.5;
    // * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%

    private LocalDate dateJoined;
    private boolean isForeigner;
    private Gender gender;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    public EmploymentDetails(LocalDate dateJoined, boolean isForeigner, Gender gender) {
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;
    }
    public enum Gender {
        MALE, FEMALE
    }

    public void setMonthlySalary(int grade) {
        if (grade < 1 || grade > SALARY_GRADES.length) {
            throw new IllegalArgumentException("Grade tidak valid");
        }
        monthlySalary = SALARY_GRADES[grade - 1];
        if (isForeigner) {
            monthlySalary *= FOREIGNER_SALARY_MULTIPLIER;
        }
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getOtherMonthlyIncome() {
        return otherMonthlyIncome;
    }

    public int getMonthWorkingInYear() {
        LocalDate now = LocalDate.now();
        return (now.getYear() == dateJoined.getYear()) ? now.getMonthValue() - dateJoined.getMonthValue() + 1 : 12;
    }

    public int getAnnualDeductible() {
        return annualDeductible;
    }

    public int getAnnualIncomeTax(String spouseIdNumber, int numberOfChildren) {
        //Menghitung berapa lama pegawai bekerja dalam setahun ini.
        LocalDate now = LocalDate.now();
        // jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
        int monthWorkingInYear = (now.getYear() == dateJoined.getYear()) ? now.getMonthValue() - dateJoined.getMonthValue() : 12;
        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), numberOfChildren);
    }
}

