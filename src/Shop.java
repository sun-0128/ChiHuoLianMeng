import java.util.Arrays;

/**
 * @author sunyong
 * @date 2020/04/16
 * @description
 */
public class Shop {
    private CaiPin[] caipins;
    private int caipinNum=0;

    public CaiPin[] getCaipins() {
        return caipins;
    }

    public void setCaipins(CaiPin[] caipins) {
        this.caipins = caipins;
        //菜品数量应该置为caipins.length
        this.caipinNum=caipins.length;
    }

    public int getCaipinNum() {
        return caipinNum;
    }

    public void setCaipinNum(int caipinNum) {
        this.caipinNum = caipinNum;
    }

    public CaiPin[] getCaipin() {
        return caipins;
    }

    public void setCaipin(CaiPin[] caipin) {
        this.caipins = caipin;

    }
    public boolean insert(CaiPin caipin){
        for (int i = 0; i < this.caipins.length; i++) {
            if(this.caipins[i]==null){
                caipin.setCaipinId(++caipinNum);
               this.caipins[i]=caipin;
                //3.菜品数量+1
               // this.caipinNum++;
                return true;
            }
        }
        return false;
    }
    public void setCaipin(CaiPin caipin) {
        //1.如果菜单为未初始化状态,需要初始化长度为8
        if(this.caipins==null){
            this.caipins=new CaiPin[8];
        }
        //2.赋值
        boolean flag =insert(caipin);

        if(!flag){
            //4.当数组满了,需要扩容
            CaiPin[] newCaipins=Arrays.copyOf(this.caipins,this.caipins.length+8);
            insert(caipin);//扩容完成后继续赋值
        }
    }
    //点菜
    public CaiPin getCaiPin(int caipinId){
        if(caipinId>caipinNum||caipinId<1){
            System.err.println("输入有误,不在菜品编号范围内!");
            return null;
        }
        return caipins[caipinId-1];
    }
    //点赞
    public void honorCaipin(int caipinId){
        if(caipinId>caipinNum||caipinId<1){
            System.err.println("输入有误,不在菜品编号范围内!");
            return;
        }
        caipins[caipinId-1].setHonor(caipins[caipinId-1].getHonor()+1);
    }
    //菜单展示
    public void showCaipin(){
        System.out.println("序号\t菜名\t单价\t点赞数");
        for (CaiPin caipin : caipins) {
            if(caipin!=null){
                System.out.println(caipin);
            }
        }
    }
}
