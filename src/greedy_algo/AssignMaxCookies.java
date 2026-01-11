package greedy_algo;

// Assign Maximum Cookies

import java.util.Arrays;

/*
Given two arrays, greed[] and cookie[] such that greed[i] denotes the minimum cookie size wanted by ith child and cookie[i] denotes the size of ith cookie, we have to find the maximum number of children that can be satisfied by assigning them cookies, with each child getting at most 1 cookie.

Note: A child will be satisfied if he is assigned a cookie of size at least equal to his greed. In other words, the ith child will be satified with jth cookie only if greed[i] <= cookie[j].

Examples:

Input: greed[] = [1, 10, 3], cookie[] = [1, 2,3]
Output: 2
Explanation: We can only assign  cookie to the first child and third child.

Input: greed[] = [10,100], cookie[] = [1, 2]
Output: 0
Explanation: We can not assign cookies to children.
*/
public class AssignMaxCookies {

    int maxChildren(int[] greed, int[] cookie) {
        Arrays.sort(greed);
        Arrays.sort(cookie);

        int i = 0, j = 0, count = 0;

        while (i < greed.length && j < cookie.length) {

            if (cookie[j] >= greed[i]) {
                // If ith child can be satisfied with jth cookie,
                // assign it to him and increment the count
                count++;
                i++;
                j++;
            } else
                j++;
                // If ith child cannot be satisfied with jth
                // cookie, move to the next bigger cookie
        }
        return count;
    }

    public static void main(String[] args) {
        AssignMaxCookies assignMaxCookies = new AssignMaxCookies();

        int[] greed = {1, 10, 3};
        int[] cookie = {1, 2,3};

        System.out.println(assignMaxCookies.maxChildren(greed, cookie));
    }
}
