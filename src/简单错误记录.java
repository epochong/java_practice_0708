import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author epochong
 * @date 2019/7/10 18:01
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
//定义一个类，用来描述错误文件的信息，这里只是用来辅助解题，就不使用private等关键字了
class ErrorFile {
    // 文件名
    String fileName ;
    // 行号
    int lineNum ;
    //  错误计数 次数默认是1，因为一旦输入一个文件，它就出现了一次，当有重复文件出现的时候，在给次数加一
    int count = 1;
}
public class 简单错误记录 {
    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        List<ErrorFile> list = new ArrayList<>();
        // 死循环输入信息 调试的时候按ctrl d 跳出循环 往后执行
        while (scanner.hasNext())
        {
            ErrorFile record = new ErrorFile();
            String[] lines = scanner.nextLine().split(" "); // 将输入的每一行按空格拆分后，第一个是文件名/文件路径 第二个是行数
            String name = lines[0]; // 取得文件名
            int index = name.lastIndexOf('\\'); // 找到最后一个 \ 的下标位置 (C:\aaa\bbb.txt)，因为要获取文件名bbb.txt
            record.fileName = (index<0)?name:name.substring(index+1); // 如果index < 0 表示输入的文件名中没有 \ ,就说明输入的不是路径，而是文件名
            record.lineNum = Integer.parseInt(lines[1]); // 获取行号
            boolean flag = true; //设置一个标志
            for (ErrorFile er : list) // 遍历list集合
            {
                if (er.fileName.equals(record.fileName) && er.lineNum == record.lineNum) // 如果有文件名和行号都相同的文件，就让count++，让标志flag = false
                {
                    er.count++;
                    flag = false;
                }
            }
            if (flag) // 如果flag 没有设置为false，就说明list中没有还当前这个文件信息，就把它add到list中去
            {
                list.add(record);
            }
        }
        scanner.close(); // 输入结束之后
        Collections.sort(list, (o1, o2) -> (o1.count-o2.count)*(-1)); //给list按count排序，这里使用的是lambda表达式，也可以使用下面这几行代码代替

        // 遍历list中前8个元素
        for (int i=0; i<((list.size()>8)?8:list.size()); i++)
        {
            ErrorFile er = list.get(i);
            String fileName = er.fileName;
            String name = (fileName.length()>16)?fileName.substring(fileName.length()-16):fileName;
            int lineNum = er.lineNum;
            int count = er.count;
            System.out.println(name+" "+lineNum+" "+count);
        }
    }
}
