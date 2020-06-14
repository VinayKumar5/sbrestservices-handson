package com.cognizant.springlearn.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

	public class Employee {	
		
		@NotNull
		@Min(value=1)
		private int id;
		
		@NotNull
		@NotBlank
		@Size(min=1, max=30)
		private String name;
		
		@NotNull
		@Min(value=0)
		private int salary;
		
		@NotNull
		private boolean permanent;
		
		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
		private Date dateOfBirth;

		public Employee() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public boolean isPermanent() {
			return permanent;
		}

		public void setPermanent(boolean permanent) {
			this.permanent = permanent;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
					+ ", dateOfBirth=" + dateOfBirth + "]";
		}

	}
