import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author sunyong
 * @date 2020/04/16
 * @description
 */
public class Test {
    public static void main(String[] args) {
        PlatForm pf = new PlatForm();
        Scanner input = new Scanner(System.in);
        int num=0;
        Shop s = new Shop();
        CaiPin c = new CaiPin("大盘鸡",90,1);
        CaiPin sheep = new CaiPin("羊肉泡",24,2);
        CaiPin duck = new CaiPin("盐水鸭",30,3);
        s.setCaipin(c);
        s.setCaipin(sheep);
        s.setCaipin(duck);
        do {
            FrontPage.showPage();
            try{
                num= input.nextInt();
            }catch (InputMismatchException e){
                System.err.println("输入的不是整数,退出系统!");
                break;
            }
            switch (num){
                case 1:
                    System.out.println("我要订餐!");
                    System.out.println("请输入订餐人姓名:");
                    String name = input.next();
                    s.showCaipin();
                    System.out.println("请输入编号:");
                    CaiPin order =null;
                    try{
                        int num2 = input.nextInt();
                        order=s.getCaiPin(num2);
                        String caipinName=null;
                        double caipinPrice =0;
                        if(order==null){
                            break;
                        }else {
                            caipinName=order.getName();
                            caipinPrice=order.getPrice();
                        }
                        boolean rst = false;
                        int pieces =1;
                        do{
                            System.out.println("请输入份数:");
                            pieces=input.nextInt();
                            rst= FrontPage.isCorrect(input,pieces,1,Integer.MAX_VALUE);
                        }while (!rst);
                        int time2 =0;
                        do{
                            System.out.println("输入送餐时间(10-20)");
                            time2=input.nextInt();
                            rst=FrontPage.isCorrect(input,time2,10,20);
                        }while (!rst);
                        System.out.println("输入地址:");
                        String addr =input.next();
                        System.out.println("订餐成功!");
                        System.out.println("\t菜单编号\t菜名\t单价\t点赞数"+"\t份数");
                        System.out.println("您订的是:"+order+"\t"+pieces);
                        System.out.println("送餐时间:"+time2);
                        Bill bill=FrontPage.order(caipinName,caipinPrice,order.getCaipinId(),name,addr,pieces,time2);
                        pf.setBill(bill);
                        System.out.println("序号\t姓名\t餐品信息\t送餐时间\t送餐地址\t总金额\t订单状态");
                        System.out.println(bill);

                    }catch (InputMismatchException e){
                        System.out.println("输入不是整数!");
                    }
                    break;
                case 2:
                    System.out.println("查看餐袋!");
                    pf.showBills();
                    break;
                case 3:
                    System.out.println("签收订单!");
                    pf.showBills();
                    System.out.println("请输入要签收订单的编号:");
                    int num4 =input.nextInt();
                    pf.qianshou( pf.getBill(num4));
                    break;
                case 4:
                    System.out.println("删除订单!");
                    pf.showBills();
                    System.out.println("请输入要删除的订单编号:");
                    int num5 =input.nextInt();
                    pf.delete(num5);
                    break;
                case 5:
                    System.out.println("我要点赞!");
                    s.showCaipin();
                    System.out.println("输入编号:");
                    CaiPin order2 =null;
                    try {
                        int num3 = input.nextInt();
                        order2=s.getCaiPin(num3);
                        pf.honor(order2);
                        s.showCaipin();
                    }catch (InputMismatchException e){
                        System.out.println("输入不是整数!");
                    }
                    break;
                case 6:
                    System.out.println("退出系统!");
                    num=-1;
                    break;
                default:
                    System.err.println("输入错误,退出系统!");
                    num=-1;
                    break;
            }
            if(num==-1){
                break;
            }else {
                num=0;
            }
        }while (num==0);
        System.out.println("谢谢使用,欢迎下次光临!");
    }
}
