package com.bridgelabz.empWage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EmployeeWageComputation implements IempWage {

	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	  private int noOfCompany=0;
	  private LinkedList<EmpWage> companyEmpWageList;
	  private Map<String,EmpWage> companyToEmpWageMap;
	 
	  public EmployeeWageComputation() {
	    companyEmpWageList=new LinkedList<EmpWage>();
	    companyToEmpWageMap=new HashMap<>();
	 }
	  
	  public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
	    EmpWage companyEmpWage=new EmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
	    companyEmpWageList.add(companyEmpWage);
	    companyToEmpWageMap.put(company, companyEmpWage);
	 }
	  public void computeEmpWage() {
	    for(int i=0;i<companyEmpWageList.size();i++) {
	    	EmpWage companyEmpWage=companyEmpWageList.get(i);
	        companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
	        System.out.println(companyEmpWage);
	    }
	 }
	  
	 public int getTotalWage(String company) {
		 return companyToEmpWageMap.get(company).totalEmpWage;
		 
	 }
	 public int computeEmpWage(EmpWage companyEmpWage) {
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
	     System.out.println("Day#: "+totalWorkingDays+" Emp Hr: "+empHrs+" Daily Wage: "+empHrs*companyEmpWage.empRatePerHour);
	   }
	   return totalEmpHrs*companyEmpWage.empRatePerHour;
	 }
	 public static void main(String[] args) {
		IempWage empWageMul=new EmployeeWageComputation();
	    empWageMul.addCompanyEmpWage("DMart", 20, 2, 10);
	    empWageMul.addCompanyEmpWage("Reliance", 10, 4, 20);
	    empWageMul.computeEmpWage();
	    System.out.println("total Wage for DMart comapny is "+empWageMul.getTotalWage("DMart"));
	}

}
