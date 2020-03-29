import java.io.*;

public class Lib {
    public static int [][] array = new int[9][9];
    public static int m;
    public static int n;

    private static boolean legal (int n,int x,int y,int m){
        //把即将填入的数字与该空的对应的行列和宫上的数字进行比较，如果相同则不能填入该空
        for(int i=0;i<m;i++){
            //判断与该行该列的数字是否相同
            if(array[x][i]==n||array[i][y]==n)
            {
                return false;
            }
        }
        if(m==9) {
            for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++) {
                for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++) {
                    if (array[i][j] == n)
                    {
                        return false;
                    }
                }
            }
        }
        if (m==4){
            for (int i = (x / 2) * 2; i < (x / 2 + 1) * 2; i++) {
                for (int j = (y / 2) * 2; j < (y / 2 + 1) * 2; j++) {
                    if (array[i][j] == n)
                    {
                        return false;
                    }
                }
            }
        }
        if(m==6) {
            for (int i = (x / 2) * 2; i < (x / 2 + 1) * 2; i++) {
                for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++) {
                    if (array[i][j] == n)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /*以深度优先算法填入数字*/
    public static boolean DFS(int x,int m){
        int i,j;
        //行列
        i = x/m;
        j = x%m;
        //填完最后一空则返回true
        if(x==m*m){
            return true;
        }
        if(array[i][j]!=0)
        {
            //继续填下一空
            return DFS(x+1,m);
        }
        for(int n=1;n<=m;n++){
            if(legal(n,i,j,m)){
                array[i][j] = n;
                if(DFS(x+1,m))
                {
                    //如果下一空结果正确则返回true；
                    return true;
                }
                /*
                  如果下一空没有可以填入的数字则应
                  清除该空已填入的数据，填入下一个可用数字
                 */
                array[i][j] = 0;
            }
        }
        //该空找不到可以填入的数字，返回false以返回到上一空
        return false;
    }
    //读文件、写文件、调用函数求解
    public void solve(int n,String inputFile,String outputFile,int m){
        File input = new File(inputFile);
        File output = new File(outputFile);
        if(!input.exists()){
            System.out.println("对不起，不包含指定路径的文件");
        }else{
            try{
                BufferedReader reader = new BufferedReader(new FileReader(input));
                BufferedWriter writer =new BufferedWriter(new FileWriter(output));
                //l表示当前读到第几盘
                for(int l=0;l<n;l++){
                    for(int i=0;i<m;i++){
                        //读入该行
                        String s = reader.readLine();

                        String str = s.replace(" ","");
                        for(int j=0;j<m;j++){
                            char [] chars = str.toCharArray();
                            array[i][j] = chars[j]-48;
                        }
                    }
                    //调用函数解数独
                    if(DFS(0,m)){
                        for(int i=0;i<m;i++){
                            for(int j=0;j<m;j++){
                                writer.write(array[i][j]+" ");
                            }
                            writer.newLine();
                        }
                        System.out.println("Success!");
                    }else {
                        writer.write("no result");
                        System.out.println("The test is insoluble!");
                    }
                    writer.newLine();
                    String s = reader.readLine();
                }
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
