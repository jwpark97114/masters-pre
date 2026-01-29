import java.util.Stack;
import java.util.ArrayList;
import java.util.Set;


public class Maze {

    static final int[][] directions = {
            {0,1},{0,-1},{1,0},{-1,0}
    };

    static int[][][] previous = new int[8][8][2];

    static boolean[][] visited = new boolean[8][8];

    static int[][] myMaze ={
            {0, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0}

    };

    static Stack<int[]> frontier = new Stack<int[]>();

    static void printPath(){
        int[] curPos = previous[7][7];
        int x = curPos[0];
        int y = curPos[1];
        StringBuilder path = new StringBuilder("(7,7)");

        while(x !=0 || y !=0){
            path.insert(0, "("+x+","+y+")->");
            int[] tmp = previous[x][y];
            x = tmp[0];
            y = tmp[1];
        }
        path.insert(0,"(0,0)->");
        System.out.println(path.toString());
    }

    public static void main(String[] args) {

        frontier.push(new int[]{0,0});

        // start = 0,0
        // exit = 7,7

        while(!frontier.empty()){
            int[] curPos = frontier.pop();

            if (curPos[0] == 7 && curPos[1]==7){
                break;
            }

            for(int[] dir: directions){
                int x = curPos[0] + dir[0];
                int y = curPos[1] + dir[1];

                if(x>=0 && x<8 && y>= 0 && y <8 && myMaze[x][y]==0 && !visited[x][y]){
                    visited[x][y] = true;
                    previous[x][y] = new int[]{curPos[0],curPos[1]};
                    frontier.push(new int[]{x,y});
                }


            }
        }

        printPath();
    }


}
