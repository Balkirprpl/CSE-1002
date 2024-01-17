// Java program to find k distant string
import java.util.*;
import java.lang.*;

public class LetterDistance {
	
	// function to find
	// the lost string
	public static String findKDistantString
					(String str1, int k)
	{
		int n = str1.length();
		char[] str = str1.toCharArray();
		
		for (int i = 0; i < n; ++i) {
			char best_letter = str[i];
			int best_distance = 0;
			
			for (char maybe = 'a';
				maybe <= 'z'; ++maybe)
			{
				int distance =
					Math.abs(maybe - str[i]);

				// Check if "distance <= k"
				// so that it should not
				// exceed the total distance
				// among letters with "distance
				// <= k" we choose the most
				// distant one
				if (distance <= k && distance
								> best_distance)
				{
					best_distance = distance;
					best_letter = maybe;
				}
			}

			// we decrease the remaining
			// distance
			k -= best_distance;
			str[i] = best_letter;
		}
		
		assert(k >= 0);
		
		// Correct string only
		// if "k == 0"
		if (k > 0)
			return "No";
		else
			return (new String(str));
	}
	public static void main(String argc[])
	{
		String str = "bear";
		int k = 26;
		System.out.println(findKDistantString(str, k));

		str = "af";
		k = 7;
		System.out.println(findKDistantString(str, k));
	}
}
