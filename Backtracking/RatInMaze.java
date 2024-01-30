import java.util.ArrayList;

public class RatInMaze {
    public static void findPathUtil(int[][] m ,int n ,boolean [][] vis , ArrayList<String> str ,int i,int j,String move)
    {
        if(i==n-1 && j==n-1)
        {
            str.add(move) ;
            return ;
        }

        //downward
        if(i+1<n && !vis[i+1][j] && m[i+1][j]==1)
        {

            vis[i][j]=true ;
            findPathUtil(m,n,vis,str,i+1,j,move+'D');
            vis[i][j]=false ;
        }

        //left
        if(j-1 >=0 && !vis[i][j-1]&&m[i][j-1]==1)
        {
            vis[i][j] = true ;
            findPathUtil(m,n,vis,str,i,j-1,move+'L');
            vis[i][j] = false ;
        }
        //right
        if(j+1<n && !vis[i][j+1]&&m[i][j+1]==1)
        {
            vis[i][j] = true ;
            findPathUtil(m,n,vis,str,i,j+1,move+'R') ;
            vis[i][j]=false ;
        }
        //upward
        if(i-1>=0 && !vis[i-1][j] && m[i-1][j]==1)
        {
            vis[i][j] = true ;
            findPathUtil(m,n,vis,str,i-1 ,j ,move+'U');
            vis[i][j]=false ;
        }



    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> str = new ArrayList<>() ;

        boolean[][] vis = new boolean[n][n] ;
        if(m[0][0]==1)
        {


            findPathUtil(m,n,vis,str,0,0,"") ;
        }
        return str ;


    }
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 0, 1},
                {1, 1, 1, 1}
        };
        int n = maze.length;

        ArrayList<String> paths = findPath(maze, n);

        System.out.println("Paths to reach the destination:");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
