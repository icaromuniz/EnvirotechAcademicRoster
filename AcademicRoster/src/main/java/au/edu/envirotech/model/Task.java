package au.edu.envirotech.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import au.edu.envirotech.architecture.AbstractEntity;

/**
 * The persistent class for the task database table.
 */
@Entity
@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")
public class Task extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TASK_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_SEQ")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String department;

	private String description;

	@Column(name = "finish_time")
	private Time finishTime;

	@Column(name = "follow_up_action")
	private String followUpAction;

	private String note;

	private String outcome;

	@Column(name = "start_time")
	private Time startTime;

	@Column(name = "under_plan")
	private boolean underPlan;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Task() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Time getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Time finishTime) {
		this.finishTime = finishTime;
	}

	public String getFollowUpAction() {
		return this.followUpAction;
	}

	public void setFollowUpAction(String followUpAction) {
		this.followUpAction = followUpAction;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public Time getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public boolean getUnderPlan() {
		return this.underPlan;
	}

	public boolean isUnderPlan() {
		return this.underPlan;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUnderPlan(boolean underPlan) {
		this.underPlan = underPlan;
	}

	public String getUnderPlanLabel() {
		return underPlan ? "Yes" : "No";
	}

	public void setUnderPlanLabel(String underPlanLabel) {
		this.underPlan = "Yes".equalsIgnoreCase(underPlanLabel);
	}
}