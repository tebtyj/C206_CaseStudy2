public class Activity {
	String activityName;
	String activityDescription;
	String activityRequirement;

	public Activity(String activityName, String activityDescription, String activityRequirement) {
		super();
		this.activityName = activityName;
		this.activityDescription = activityDescription;
		this.activityRequirement = activityRequirement;
	}

	public String getActivityName() {
		return activityName;
	}
	public String getActivityDescription() {
		return activityDescription;
	}
	public String getActivityRequirement() {
		return activityRequirement;
	}
	
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}
	public void setActivityRequirement(String activityRequirement) {
		this.activityRequirement = activityRequirement;
	}
}