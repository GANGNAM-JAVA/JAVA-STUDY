import java.util.HashSet;

class Solution {
	public int numUniqueEmails(String[] emails) {
		HashSet<String> resultHashSet = new HashSet<String>();

		for (String email : emails) {
			String[] atSplited = email.split("@");
			String name = atSplited[0].replace(".", "");
			String addr = atSplited[1];

			resultHashSet.add(name.split("\\+")[0] + "@" + addr);
		}
		return resultHashSet.size();
	}
}
