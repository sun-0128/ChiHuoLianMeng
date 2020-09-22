import java.util.Arrays;

/**
 * @author sunyong
 * @date 2020/04/16
 * @description
 */
public class PlatForm {
    private int billNum;
    private Bill[] bills;
    private Bill bill;

    public Bill getBill() {
        return bill;
    }
    public int getBillNum() {
        return billNum;
    }
    public void setBillNum(int billNum) {
        this.billNum = billNum;
    }

    public Bill[] getBills() {
        return bills;
    }

    public void setBills(Bill[] bills) {
        this.bills = bills;
    }

    public void showBills(){
        if(bills[0]==null){
            return;
        }else {
            System.out.println("序号\t姓名\t餐品信息\t送餐时间\t送餐地址\t总金额\t订单状态");
            for (Bill bill : bills) {
                if(bill!=null){
                    System.out.println(bill);
                }
            }
        }

    }
    public void setBill(Bill bill) {
        //1.如果菜单为未初始化状态,需要初始化长度为8
        if(this.bills==null){
            this.bills=new Bill[8];
        }
        //2.赋值
        boolean flag =insert(bill);
        //4.当数组满了,需要扩容
        if(!flag){
         bills=Arrays.copyOf(bills,bills.length+8);
          insert(bill);
        }
    }
    public boolean insert(Bill bill){
        for (int i = 0; i < bills.length; i++) {
            if(this.bills[i]==null){
                bill.setBillId(++billNum);
                this.bills[i]=bill;
                //3、订单数量应该+1
                return true;
            }
        }
        return false;
    }
    public void honor(CaiPin caiPin){
        caiPin.setHonor(caiPin.getHonor()+1);
        System.out.println("点赞成功!");
    }
    //签收
    public void qianshou(Bill bill){
        if(bill==null){
            System.out.println("无法签收,返回!");
            return;
        }
        if(bill.getStatus().equals("已预定")){
            bill.setStatus("已签收");
            System.out.println("签收成功!");
        }else{
            System.out.println("不能再次签收!");
        }
    }
    //得到订单
    public Bill getBill(int billId){
        if(billId>billNum||billId<1){
            System.out.println("输入有误,不在订单编号范围内!");
            return null;
        }
        return bills[billId-1];
    }
    //删除订单
    public void delete(int billId){
        if(billId>billNum||billId<1){
            System.out.println("不在订单编号范围内,无法删除!");
            return ;
        }
        if(getBill(billId).getStatus().equals("已预定")){
            System.out.println("未签收,不能删除");
            return;
        }
        //删除的是最后一个订单直接置空
        if(bills[billId]==null){
            bills[billId-1]=null;//置空
            System.out.println("删除成功!");
        }else {
            int i =billId;
            for ( i = billId; i < bills.length && bills[i]!=null; i++) {
                bills[i-1]=bills[i];
                bills[i-1].setBillId(i);
                //订单的序号咋改?
            }
            bills[i-1]=null;
            System.out.println("删除成功!");
        }

    }
}

