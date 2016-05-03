package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import users.DeveloperProfile1;
import users.DeveloperProfile2;
import users.DeveloperUser;


/**
 * Class to read the file with test data
 * The file itself is excluded from the repository for security reasons
 * 
 * @author Erwin
 *
 */
public class TestUserTool {

	// The program runs from the /bin/ so that is our user.dir
	private static String running_dir = System.getProperty("user.dir");
	private static String testuser_file = null;

	private static Log logger = LogFactory.getLog("Article Writer");

	/**
	 * This method will get all the articleUrls from the database 
	 * 
	 * @return List<String> with articleUrls
	 */
	public static List<DeveloperUser> getTestUsers(){
		ArrayList<DeveloperUser> users = new ArrayList<>();
		BufferedReader dbReader = null;
		String line = null;
		String fields[] = null;
		try{
			testuser_file = running_dir + "\\testusers.csv";
			dbReader = new BufferedReader(new FileReader(testuser_file));
			while((line = dbReader.readLine()) != null){
				fields = line.split(",");
				DeveloperUser user = new DeveloperUser();
				user.setUserid(fields[0]);
				user.setUserpwd(fields[1]);
				user.setUsername(fields[2]);
				if (fields[3].equals("1")){
					user.setProfile(new DeveloperProfile1());
				} else {
					user.setProfile(new DeveloperProfile2());
				}
				users.add(user);
			}
		} catch (IOException ioe){
			logger.error(ioe);
		} finally {
			try{
				dbReader.close();
			} catch (Exception e){
				logger.warn("Exception while trying to close the file reader");
			}
		}
		return users;
	}
}
