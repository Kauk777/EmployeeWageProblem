package com.bridgelabz.empWage;

public class EmployeeWageComputation {

	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	  private int noOfCompany=0;
	  private EmpWage[] companyEmpWageArray;
	 
	  public EmployeeWageComputation() {
	    companyEmpWageArray=new EmpWage[5];
	 }
	  
	  private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
	    companyEmpWageArray[noOfCompany]=new EmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
	    noOfCompany++;
	 }
	  private void computeEmpWage() {
	    for(int i=0;i<noOfCompany;i++) {
	      companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
	      System.out.println(companyEmpWageArray[i]);
	  }
	 }
	 private int computeEmpWage(EmpWage companyEmpWage) {
	     int empHrs=0, totalEmpHrs=0, totalWorkingDays=0;
	     while (totalEmpHrs<=companyEmpWage.maxHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays) {
	     totalWorkingDays++;
	     int empCheck = (int)Math.floor(Math.random() * 10)%3;
	     switch (empCheck) {
	      case IS_PART_TIME:
	      empHrs=4;
	      break;
	      case IS_FULL_TIME:
	      empHrs=8;
	      break;
	      default:
	      empHrs=0;
	   }
	     totalEmpHrs+=empHrs;
	     System.out.println("Day#: "+totalWorkingDays+" Emp Hr: "+empHrs);
	   }
	   return totalEmpHrs*companyEmpWage.empRatePerHour;
	 }
	 public static void main(String[] args) {
		EmployeeWageComputation empWageMul=new EmployeeWageComputation();
	    empWageMul.addCompanyEmpWage("DMart", 20, 2, 10);
	    empWageMul.addCompanyEmpWage("Reliance", 10, 4, 20);
	    empWageMul.addCompanyEmpWage("BigBasket", 30, 6, 25);
	    empWageMul.computeEmpWage();
	}

}
