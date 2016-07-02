
package algos;

import java.util.ArrayList;

/**
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
    You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
    Input : [(0, 0), (1, 1), (1, 2)]
	Output : 2
	It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * @author RAVI
 *
 */
public class MinStepsInGrid {

	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		int minSteps = 0;
		int x = X.get(0);
		int y = Y.get(0);
		if (X != null && Y != null && X.size() > 0 && Y.size() > 0) {
			for (int i = 1; i < X.size(); i++) {
				int steps = Math.max(Math.abs(X.get(i) - x), Math.abs(Y.get(i) - y));
				x = X.get(i);
				y = Y.get(i);
				minSteps += steps;
			}
		}
		return minSteps;
	}
}
