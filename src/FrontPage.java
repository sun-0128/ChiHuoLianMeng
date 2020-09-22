import java.util.Scanner;

/**
 * @author sunyong
 * @date 2020/04/16
 * @description
 * 展示首页和首页的功能
 */
public class FrontPage {
    //首页展示功能
    static {
        System.out.println("********欢迎来到吃货联盟订餐系统********");
    }

    public static void showPage(){
        System.out.println("请输入数字选择(1-6):");
        System.out.println("1.我要订餐\t2.查看餐袋\t3.签收订单\t4.删除订单\t5.我要点赞\t6.退出系统");
    }
    //我要点餐
    public static Bill order(String caipinName,double caipinPrice,int caipinId,String name,String address,int piece,int time){
        double dishPrice=piece*caipinPrice;
        //若超过50无需送餐费否则+6元送餐费
        double bonos = dishPrice>=50?0:6;
        double total = dishPrice+bonos;
        Bill bill = new Bill(name,caipinName+""+piece+"份",time,address,total);
        return bill;
    }
    //合法性判断
    public static boolean isCorrect(Scanner input,int param,int low,int high){
            if(param<low||param>high){
                System.out.println("输入有误,请重新输入!");
                return false;
            }
        return true;
    }
    //查看餐袋
    //签收订单
    //删除订单
    //我要点赞

}
