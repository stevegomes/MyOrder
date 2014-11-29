package com.test.QtestConnect;

public class Qtest {

	private String status;
	private String name;
	private String automation_content;
	private String exe_start_date;
	private String exe_end_date;
	private String note;

	// Must have no-argument constructor
	public Qtest() {

	}

	public Qtest(String status, String name, String automation_content, String exe_start_date, String exe_end_date, String note) {
		this.status = status;
		this.name = name;
		this.note = note;
		this.automation_content = automation_content;
		this.exe_start_date = exe_start_date;
		this.exe_end_date = exe_end_date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getstatus() {
		return this.status;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return this.note;
	}
	public void setname(String name) {
		this.name = name;
	}

	public String getname() {
		return this.name;
	}

	public void setautomation_content(String automation_content) {
		this.automation_content = automation_content;
	}

	public String getautomation_content() {
		return this.automation_content;
	}

	public void setexe_start_date(String exe_start_date) {
		this.exe_start_date = exe_start_date;
	}

	public String getexe_start_dateId() {
		return this.exe_start_date;
	}
	
	public void setexe_end_date(String exe_end_date) {
		this.exe_end_date = exe_end_date;
	}

	public String getexe_end_dateId() {
		return this.exe_end_date;
	}

	@Override
	public String toString() {
		return new StringBuffer(" status : ").append(this.status)
				.append(" name : ").append(this.name)
				.append(" note : ").append(this.note)
				.append(" automation_content : ").append(this.automation_content).append(" exe_start_date : ")
				.append(this.exe_start_date).append(" exe_end_date : ").append(this.exe_end_date).toString();
	}

}