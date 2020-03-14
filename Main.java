import java.util.Scanner;

public class Main {
    static int[][] maze;// 迷宫矩阵
    static int n;// 矩阵大小
    static int min;// 最短步长
    public static void main(String[] args) {
        long time1=System.currentTimeMillis();
            Scanner sc = new Scanner(System.in);
            System.out.println("输入迷宫大小: ");
            n=sc.nextInt();
            System.out.println("输入迷宫矩阵：");
            maze = new int[n][n];
            while(n>3){
                min = n * n;
                for (int i = 0; i <=n-1; i++)
                    for (int j = 0; j <=n-1; j++)
                        maze[i][j] = sc.nextInt();
                move(1, 1, 0);// 起始点为（1，1），初始步长为0
                if (min== n * n)
                    System.out.println("No solution");
                else
                    System.out.println("通道最短步长为:"+min);
                long time2=System.currentTimeMillis();
                long c=time2-time1;
                System.out.println(c);
            }
    }
    public static void move(int x, int y, int count) {
        if (x == n - 2 && y == n - 2)// 跳出条件，走到[n-2][n-2]位置即为终点
        {
            if (min > count)
                min = count;
        }
            else {
                if (y < n - 1 && maze[x][y + 1] == 0) {
                    maze[x][y] = 1;// 走过的位置不能重复走，故而走过就设为1（障碍物）
                    move(x, y + 1, count + 1); // 右
                    maze[x][y] = 0;// 即从该处相邻地方出发没有找到完整路径，所以将之前走过的这条路径状态恢复
                }
                if (x < n - 1 && maze[x + 1][y] == 0) {
                    maze[x][y] = 1;
                    move(x + 1, y, count + 1); // 下
                    maze[x][y] = 0;
                }
                if (x > 1 && maze[x - 1][y] == 0) {
                    maze[x][y] = 1;
                    move(x - 1, y, count + 1); // 上
                    maze[x][y] = 0;
                }
                if (y > 1 && maze[x][y - 1] == 0) {
                    maze[x][y] = 1;
                    move(x, y - 1, count + 1); // 左\
                    maze[x][y] = 0;
                }
            }
        }
    }
