package soloWord;

public class word {

//The main method must be in a class named "Main".
	
	public static void main(String[] args) {
		String str = new String("글자");
		String str2 = new String("글자");
		String str3 = "글자";
		String str4 = "글자";
		
		System.out.println("str == str2 ? ");
		if(str == str2) {
			System.out.println("true");
		} else { System.out.println("false");
		
		}
		System.out.println("str == str3 ? ");
		if(str2 == str3) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		System.out.println("str.equals(str3) ?");
		if(str.equals(str3)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		System.out.println("str.equals(str3) ? ");
		
		
	}
	
}
