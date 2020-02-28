import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;
import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RangeInRect {

    public static void main(String[] args) {
        int num = new RangeInRect().movingCount(5,10,10);
        System.out.println(num);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    int num = 0;
    int threshold,rows,cols;
    boolean[][] rect;
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold<0){
            return 0;
        }
        LinkedList<Point> list = new LinkedList<>();
        this.rows = rows;
        this.cols = cols;
        rect = new boolean[rows][cols];
        this.threshold = threshold;
        list.add(new Point(0,0));
        rect[0][0] = true;
        while (list.size() != 0){
            Point point = list.poll();
            num++;
            if (canMove(point.x - 1,point.y)){
                list.add(new Point(point.x-1,point.y));
            }
            if (canMove(point.x+1,point.y)){
                list.add(new Point(point.x+1,point.y));
            }
            if (canMove(point.x,point.y+1)){
                list.add(new Point(point.x,point.y+1));
            }
            if (canMove(point.x,point.y-1)){
                list.add(new Point(point.x,point.y-1));
            }
        }
        return num;
    }

    public boolean canMove(int x,int y){
        if (x >= 0 && y >= 0 && x < cols && y < rows && rect[y][x] == false && getSum(x,y) <= threshold){
            rect[y][x] = true;
            return true;
        }
        return false;
    }

    int getSum(int x,int y){
        int sum = 0;
        while (x != 0){
            sum += x % 10;
            x /= 10;
        }
        while (y != 0){
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }
}
