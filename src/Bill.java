/**
 * @author sunyong
 * @date 2020/04/16
 * @description
 */
public class Bill {
    private int billId;
    private String customName;
    private String caipinMsg;//包含菜品的名称 份数
    private int sendTime;
    private String sendAddress;
    private double totalPrice;//菜品的单价*份数
    private String status="已预定";//默认已预定

    public Bill(String customName, String caipinMsg, int sendTime, String sendAddress, double totalPrice) {
        this.customName = customName;
        this.caipinMsg = caipinMsg;
        this.sendTime = sendTime;
        this.sendAddress = sendAddress;
        this.totalPrice = totalPrice;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCaipinMsg() {
        return caipinMsg;
    }

    public void setCaipinMsg(String caipinMsg) {
        this.caipinMsg = caipinMsg;
    }

    public int getSendTime() {
        return sendTime;
    }

    public void setSendTime(int sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  billId +
                "\t" + customName +
                "\t\t" + caipinMsg +
                "\t\t\t" + sendTime +
                "\t" + sendAddress +
                "\t" + totalPrice +
                "\t" + status;
    }
}
