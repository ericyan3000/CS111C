
public class HomeworkM1Driver {

	public static void main(String[] args) {
		
		System.out.println("******************************Testing id Criteria");
		System.out.println("These ids meet the criteria- should print true.");
		System.out.println("\t" + meetsCriteria("d4x1m4m2", 'x', 'm', 2) + "\texactly 2 m's after x");  
		System.out.println("\t" + meetsCriteria("vdev4x1v3v", 'e', 'v', 3) + "\texactly 3 v's after x; also 1 extra v before x- that doesn't affect the criteria");
		System.out.println("\t" + meetsCriteria("d4g1b4gb5", 'g', 'b', 2) + "\texactly 2 b's after the first g; also a second g- that doesn't affect the criteria");
		System.out.println("\t" + meetsCriteria("d4xX1m4m2", 'X', 'm', 2) + "\texactly 2 m's after x");  
		System.out.println("\t" + meetsCriteria("vdev4VVVx1v3v", 'e', 'V', 3) + "\texactly 3 v's after x; also 1 extra v before x- that doesn't affect the criteria");
		System.out.println("\t" + meetsCriteria("d4g1B4gbB5", 'g', 'B', 2) + "\texactly 2 b's after the first g; also a second g- that doesn't affect the criteria");
		
		
		System.out.println("\nThese ids do NOT the criteria- should print false.");
		System.out.println("\t" + meetsCriteria("ad6c4z1a43sh", 'z', 'a', 2) + "\t only 1 a after the z- the other a comes before the z");
		System.out.println("\t" + meetsCriteria("ddc4f1q4qq", 'f', 'q', 2) + "\t 3 q's after the f");
		System.out.println("\t" + meetsCriteria("kdc2m1m4rv", 'k', 'm', 1) + "\t no k");
		System.out.println("\t" + meetsCriteria("sbbbf41n", 'b', 'b', 3) + "\t the first b is the firstChar; there are then only *2* other b's *after* that");
		System.out.println("\t" + meetsCriteria("sbbbf41n", 'z', 'b', 3));
		System.out.println("\t" + meetsCriteria("d4x1m4M2", 'x', 'm', 2) + "\t false upper M and lower m not the same");  
		System.out.println("\t" + meetsCriteria("vdEv4x1v3v", 'e', 'v', 3) + "\t false No lower e");
		System.out.println("\t" + meetsCriteria("d4g1b4Bgb5", 'g', 'b', 2) + "\t True B and b not the same");
		
		System.out.println("\n\n******************************Testing e-Mail Validator (Extra Credit)");
		// valid
		String s1 = "janeeyre@email.com";
		String s2 = "markdarcy@gmail.abc";
		String s3 = "dr.frankenstein@monster.com";
		String s4 = "!@abc.xyz";
		
		// invalid
		String s5 = "@abc.xyz"; // no characters before @
		String s6 = "abc.com"; // no @
		String s7 = "j@com"; // no period
		String s8 = "jm@gmail.comm"; // 4 chars after the prior
		String s9 = "jm@gmail.hi"; // 2 chars after period
		String s10 = "jm@gmail.z"; // 1 chars after period
		String s11 = "abcdef"; // no @ or .
		String[] tests = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11};
		boolean[] results = {true, true, true, true, false, false, false, false, false, false, false};
		for(int i=0; i<tests.length; i++) {
			System.out.println(isValidEmail(tests[i]) +	" : " + results[i] + " for " + tests[i]);
		}

	}
	
	public static boolean isValidEmail(String email) {
		if (email.indexOf("@") == -1 || email.indexOf('.', email.indexOf('@')) == -1) 
			return false;
		else {
			String pre = "";
			String domain = "";
			
			pre = email.substring(0, email.indexOf('@'));
			domain = email.substring(email.indexOf('.', email.indexOf('@')) + 1);
	
			return ( pre.length() > 0 && domain.length() == 3);
		}
	}
	
	public static boolean meetsCriteria(String id, char first, char second, int numberTimesSecondAfterFirst) {
		String subString = id.substring(id.indexOf(first) + 1);
		int count = 0; 
		
		if (!subString.equals(id)) {
			for ( char c : subString.toCharArray()) {
				if (c == second)
					count ++;
			}
		
			return count == numberTimesSecondAfterFirst;
		}
		else
			return false;
		}
}
