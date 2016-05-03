package users;

/**
 * Simple dto to store article information
 * @author Erwin
 */
public class DeveloperUser {

	private String username = null;
	private String userpwd = null;
	private String userid = null;
	private DeveloperProfile profile = null;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public DeveloperProfile getProfile() {
		return profile;
	}
	public void setProfile(DeveloperProfile profile) {
		this.profile = profile;
	}
}
