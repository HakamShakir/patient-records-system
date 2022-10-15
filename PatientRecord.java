package SystemForPatients;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class PatientRecord {

	
	private String name, surName,chiefComplaint, history, vitals, investigation, treatement, recommendation,duration;
	private Gender gender;
	private LocalDate DOB, DateOfSubmission;
	private int patientId, drId;
	/**
	 * @param name
	 * @param surName
	 * @param chiefComplaint
	 * @param history
	 * @param vitals
	 * @param investigation
	 * @param treatement
	 * @param recommendation
	 * @param gender
	 * @param dOB
	 * @param DateOfSubmission
	 * @param patientId
	 * @param drId
	 */
	public PatientRecord(String name, String surName, String chiefComplaint, String history, String vitals,
			String investigation, String treatement, String recommendation, Gender gender, LocalDate dOB, LocalDate DateOfSubmission,
			int patientId, int drId, String duration) {
		super();
		this.name = name;
		this.surName = surName;
		this.chiefComplaint = chiefComplaint;
		this.history = history;
		this.vitals = vitals;
		this.investigation = investigation;
		this.treatement = treatement;
		this.recommendation = recommendation;
		this.gender = gender;
		DOB = dOB;
		this.DateOfSubmission = DateOfSubmission;
		this.patientId = patientId;
		this.drId = drId;
		this.duration = duration;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getChiefComplaint() {
		return chiefComplaint;
	}
	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getVitals() {
		return vitals;
	}
	public void setVitals(String vitals) {
		this.vitals = vitals;
	}
	public String getInvestigation() {
		return investigation;
	}
	public void setInvestigation(String investigation) {
		this.investigation = investigation;
	}
	public String getTreatement() {
		return treatement;
	}
	public void setTreatement(String treatement) {
		this.treatement = treatement;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public Gender getgender() {
		return gender;
	}
	public void setgender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDOB() {
		return DOB;
	}
	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}
	public LocalDate getDateOfSubmission() {
		return DateOfSubmission;
	}
	public void setDateOfSubmission(LocalDate DateOfSubmission) {
		this.DateOfSubmission = DateOfSubmission;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDrId() {
		return drId;
	}
	public void setDrId(int drId) {
		this.drId = drId;
	}
	@Override
	public String toString() {
		return "PatientRecord [name=" + name + ", surName=" + surName + ", chiefComplaint=" + chiefComplaint
				+ ", history=" + history + ", vitals=" + vitals + ", investigation=" + investigation + ", treatement="
				+ treatement + ", recommendation=" + recommendation + ", gender=" + gender + ", DOB=" + DOB
				+ ", DateOfSubmission=" + DateOfSubmission + ", patientId=" + patientId + ", drId=" + drId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(DOB, DateOfSubmission, chiefComplaint, drId, history, investigation, name, patientId,
				recommendation, gender, surName, treatement, vitals);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientRecord other = (PatientRecord) obj;
		return Objects.equals(DOB, other.DOB) && Objects.equals(DateOfSubmission, other.DateOfSubmission)
				&& Objects.equals(chiefComplaint, other.chiefComplaint) && drId == other.drId
				&& Objects.equals(history, other.history) && Objects.equals(investigation, other.investigation)
				&& Objects.equals(name, other.name) && patientId == other.patientId
				&& Objects.equals(recommendation, other.recommendation) && gender == other.gender
				&& Objects.equals(surName, other.surName) && Objects.equals(treatement, other.treatement)
				&& Objects.equals(vitals, other.vitals);
	}
	
	

}