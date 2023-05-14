package cn.llynsyw.junit.junit2.test;

import java.util.Scanner;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/8
 **/
public class CorrectTax {
	public double countTax(double salary) {
		double temp = salary - 2000;
		double tax = 0;
		if (temp <= 0) {
			tax = 0;
		}
		if (temp > 0) {
			if (temp > 500) {
				tax += 500 * 0.05;
			} else {
				tax += temp * 0.05;
			}
		}
		if (temp - 500 > 0) {
			if (temp > 2000) {
				tax += 1500 * 0.10;
			} else {
				tax += (temp - 500) * 0.10;
			}
		}
		if (temp - 2000 > 0) {
			if (temp > 5000) {
				tax += 3000 * 0.15;
			} else {
				tax += (temp - 2000) * 0.15;
			}
		}
		if (temp - 5000 > 0) {
			if (temp > 20000) {
				tax += 15000 * 0.20;
			} else {
				tax += (temp - 5000) * 0.20;
			}
		}
		if (temp - 20000 > 0) {
			if (temp > 40000) {
				tax += 20000 * 0.25;
			} else {
				tax += (temp - 20000) * 0.25;
			}
		}
		if (temp - 40000 > 0) {
			if (temp > 60000) {
				tax += 20000 * 0.3;
			} else {
				tax += (temp - 40000) * 0.3;
			}
		}
		if (temp - 60000 > 0) {
			if (temp > 80000) {
				tax += 20000 * 0.35;
			} else {
				tax += (temp - 60000) * 0.35;
			}
		}
		if (temp - 80000 > 0) {
			if (temp > 100000) {
				tax += 20000 * 0.4;
			} else {
				tax += (temp - 80000) * 0.4;
			}
		}
		if (temp - 100000 > 0) {
			tax += (temp - 100000) * 0.45;
		}

		return tax;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CorrectTax tax = new CorrectTax();
		while (true) {
			System.out.print("input the salary:");
			int salary = sc.nextInt();
			System.out.println("salary : " + salary + " tax : " + tax.countTax(salary));
		}
	}
}
