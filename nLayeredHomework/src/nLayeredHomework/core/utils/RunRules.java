package nLayeredHomework.core.utils;

public class RunRules {
	public static boolean run(boolean... params) {
		for(boolean param : params) {
			if(!param) {
				return false;
			}
		}
		return true;
	}

}
