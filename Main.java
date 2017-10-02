import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static final String alphabet = "{},";
	private static char[] word;
	private static int length;
	private static Boolean[][] set;
	private static Boolean[][] elementList;
	private static Boolean[][] list;
	private static Boolean[][] element;
	private static Boolean[][] atom;

	// start and end are inclusive and indicating the range of word to be
	// considered as a substring
	public static boolean isSet(int start, int end) {
		if (set[start][end] != null) {
			return set[start][end];
		}
		if (end <= start || word[start] != '{' || word[end] != '}' || !isElementList(start + 1, end - 1)) {
			set[start][end] = false;
		} else {
			set[start][end] = true;
		}
		return set[start][end];
	}

	public static boolean isElementList(int start, int end) {
		if (elementList[start][end] != null) {
			return elementList[start][end];
		}
		if (end < start) {
			elementList[start][end] = true;
		} else {
			elementList[start][end] = isList(start, end);
		}
		return elementList[start][end];
	}

	public static boolean isList(int start, int end) {
		if (list[start][end] != null) {
			return list[start][end];
		}
		if (end < start) {
			list[start][end] = false;
			return false;
		}
		if (isElement(start, end)) {
			list[start][end] = true;
			return true;
		}
		for (int i = start + 1; i < end; i++) {
			if (word[i] == ',' && isElement(start, i - 1) && isList(i + 1, end)) {
				list[start][end] = true;
				return true;
			}
		}
		list[start][end] = false;
		return false;
	}

	public static boolean isElement(int start, int end) {
		if (element[start][end] != null) {
			return element[start][end];
		}
		if (end < start || !isAtom(start, end) && !isSet(start, end)) {
			element[start][end] = false;
		} else {
			element[start][end] = true;
		}
		return element[start][end];
	}

	public static boolean isAtom(int start, int end) {
		if (atom[start][end] != null) {
			return atom[start][end];
		}
		if (start != end || alphabet.indexOf(word[start]) < 0) {
			atom[start][end] = false;
		} else {
			atom[start][end] = true;
		}
		return atom[start][end];
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(in.readLine());
		for (int k = 1; k <= n; k++) {
			word = in.readLine().toCharArray();
			length = word.length;
			set = new Boolean[length][length];
			elementList = new Boolean[length][length];
			list = new Boolean[length][length];
			element = new Boolean[length][length];
			atom = new Boolean[length][length];
			if (isSet(0, length - 1)) {
				System.out.printf("Word #%d: Set%n", k);
			} else {
				System.out.printf("Word #%d: No Set%n", k);
			}
		}
	}

}
