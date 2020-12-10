import java.util.ArrayList;
import java.util.NoSuchElementException;
public class RangeTester {

	public static void main(String[] args) {
		boolean failure = false;
		failure = failure || constructorTester(1000);
		failure = failure || lengthTester(1000);
		failure = failure || hasNextTester(1000);
		failure = failure || nextTester(1000);
		failure = failure || resetTester(1000);

		System.out.println("\n ~~~ Overall Result ~~~");
		if (failure) {
			System.out.println("Coal for you!");
		} else {
			System.out.println("Happy Holidays!");
		}
	}

	private static void tester(String test) {
		System.out.println("\n ~~~ " + test + " ~~~\n");
	}

	private static int randInt(int end) {
		return randInt(0, end);
	}

	private static int randInt(int start, int end) {
		return (int)(Math.random()* (end - start)) + start;
	}

	private static void passMessage(int testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	private static void passMessage(String testCase) {
		System.out.println("Test case " + testCase + " passed.");
	}

	private static void methodMessage(String method, boolean failure) {
		if (failure) {
			System.out.println("\nAt least one test case failed for " + method);
		} else {
			System.out.println(method + " PASSED");
		}
	}

	public static boolean constructorTester(int tests) {
		String method = "constructorTester";
		tester(method);
		boolean fail = false;
		//should return true
		for (int test = 0; test < tests; test++) {
			int start = randInt(-100, 100);
			int end = start + randInt(10);
			try {
				//tests actually works
				Range r = new Range(start, end);
				//tests implements IntegerSequence
				IntegerSequence r1 = new Range(start, end);
				//passMessage(test);
			} catch (Exception e) {
				e.printStackTrace();
				fail = true;
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
			}

			end = start - (1 + randInt(10));
			try {
				//tests actually works
				Range r = new Range(start, end);
				//tests implements IntegerSequence
				IntegerSequence r1 = new Range(start, end);
				fail = true;
				System.out.println("Expected error!");
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
			} catch (Exception e) {
				//passMessage(test);
			}

		}

		try {
			IntegerSequence r1 = new Range(1, 0);
			fail = true;
			System.out.println("If end < start and it creates the range, you're not in spec!");
		} catch (Exception e) {
			//System.out.println("Easy test, right?");
		}

		methodMessage(method, fail);
		return fail;
	}

	public static boolean lengthTester(int tests) {
		tester("lengthTester");
		boolean fail = false;
		for (int test = 0; test < tests; test++) {
			int start = randInt(-100, 100);
			int end = start + randInt(10);
			Range r = new Range(start, end);
			ArrayList<Integer> equivalent = new ArrayList<Integer>();

			for (int n = start; n <= end; n++) {
				equivalent.add(n);
			}

			if (equivalent.size() == r.length()) {
				//passMessage(test);
			} else {
				fail = true;
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
				System.out.println("Expected: " + equivalent.size());
				System.out.println("Actual: " + r.length());
			}
		}

		methodMessage("lengthTester", fail);
		return fail;
	}

	public static boolean hasNextTester(int tests) {
		tester("hasNextTester");
		boolean fail = false;
		for (int test = 0; test < tests; test++) {
			int start = randInt(-100, 100);
			int end = start + randInt(10);
			Range r = new Range(start, end);
			ArrayList<Integer> equivalent = new ArrayList<Integer>();

			for (int n = start; n <= end; n++) {
				equivalent.add(n);
			}

			int current = start;

			for (int n : equivalent) {
				if (r.hasNext()) {
					current = r.next();
					/* passMessage(test);
					System.out.println("Start: " + start);
					System.out.println("End: " + end);
					System.out.println("Current: " + current); */
				} else {
					fail = true;
					System.out.println("Start: " + start);
					System.out.println("End: " + end);
					System.out.println("Current: " + current);
				}
			}

			if (r.hasNext()) {
				fail = true;
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
				System.out.println("Current: " + current);
			} else {
				/*passMessage(test);
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
				System.out.println("Current: " + current);*/
			}
		}

		methodMessage("hasNextTester", fail);
		return fail;
	}

	public static boolean nextTester(int tests) {
		tester("nextTester");
		boolean fail = false;
		for (int test = 0; test < tests; test++) {
			int start = randInt(-100, 100);
			int end = start + randInt(10);
			Range r = new Range(start, end);
			ArrayList<Integer> equivalent = new ArrayList<Integer>();

			for (int n = start; n <= end + 1; n++) {
				equivalent.add(n);
			}

			int current = start;

			for (int n : equivalent) {
				if (n != equivalent.get(0)) {//passes first element for future checks to work
					if (current == n - 1) {
						//passMessage(test);
						//System.out.println("Current: " + current);
					} else {
						fail = true;
						System.out.println("Start: " + start);
						System.out.println("End: " + end);
						System.out.println("Current: " + current);
					}
					if (r.hasNext()) {
						current = r.next();
					}
				} else {
					if (r.hasNext()) {
						current = r.next();
					}
				}
			}

			try {
				current = r.next();
				fail = true;
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
				System.out.println("Current: " + current);
			} catch (NoSuchElementException e) {
				/*passMessage(test);
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
				System.out.println("Current: " + current);*/
			}

		}

		methodMessage("nextTester", fail);
		return fail;
	}

	public static boolean resetTester(int tests) {
		tester("resetTester");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			ArrayList<Integer> x = new ArrayList<Integer>();
			ArrayList<Integer> y = new ArrayList<Integer>();
			int start = randInt(-100, 100);
			int end = start + randInt(10);
			Range r = new Range(start, end);

			while (r.hasNext()) {
				x.add(r.next());
			}
			r.reset();
			while(r.hasNext()) {
				y.add(r.next());
			}

			if (x.equals(y)) {
				//passMessage(test);
			} else {
				fail = true;
				System.out.println("Original Case: " + x.toString());
				System.out.println("Reset case: " + y.toString());
				System.out.println("Start: " + start);
				System.out.println("End: " + end);
			}
		}

		methodMessage("resetTester", fail);
		return fail;
	}

}
