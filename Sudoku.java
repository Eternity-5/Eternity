public class Sudoku{
    public static int m;
    public static int n;
    public static String inputFileName;
    public static String outputFileName;

    /**
     * 用于判断输入格式对错
     */
    public static boolean True1(String str) {
        if(str.equals("0") || str.equals("1") || str.equals("2") || str.equals("3")
                || str.equals("4") || str.equals("5") || str.equals("6") ||
                str.equals("7") || str.equals("8") || str.equals("9")) {
            return true;
        }
        if(str.contains(".txt")) {
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * 命令行传参
     */
    public static void loadArgs(String[] args) {
        if(args.length > 0 && args != null) {
            for(int i = 0; i < args.length; i++) {
                switch(args[i]) {
                    case "-m":
                        i++;
                        if(True1(args[i]))
                        {
                            m = Integer.parseInt(args[i]);
                        }
                        else
                        {
                            System.out.println("缺少数独阶数m……");
                        }
                        break;
                    case "-n":
                        i++;
                        if(True1(args[i]))
                        {
                            n = Integer.parseInt(args[i]);
                        }
                        else
                        {
                            System.out.println("缺少数独个数n……");
                        }
                        break;
                    case "-i":
                        i++;
                        if(True1(args[i]))
                        {
                            inputFileName = args[i];
                        }
                        else
                        {
                            System.out.println("读取文件格式不正确……");
                        }
                        break;
                    case "-o":
                        i++;
                        if(True1(args[i]))
                        {
                            outputFileName = args[i];
                        }
                        else
                        {
                            System.out.println("输出文件格式不正确……");
                        }
                        break;
                    default:
                        System.out.println("请按格式输入……");
                        break;
                }
            }
        }else {
            System.out.println("未输入参数……");
            System.exit(1);
        }
    }

    public static void main(String [] args){
        loadArgs(args);
        //字符串对象中的字符转换为一个字符数组。
        char[] ch = args[1].toCharArray();
        //把 char 转成了 int
        int m = ch[0]-48;
        char[] chars = args[3].toCharArray();
        int n = chars[0] - 48;
        Lib lib=new Lib();
        try{
            lib.solve(n,args[5],args[7],m);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}