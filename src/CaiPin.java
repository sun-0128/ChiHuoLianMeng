/**
 * @author sunyong
 * @date 2020/04/16
 * @description
 * 菜品类
 */
public class CaiPin {
    private int caipinId;

    public int getCaipinId() {
        return caipinId;
    }

    public void setCaipinId(int caipinId) {
        this.caipinId = caipinId;
    }


    private String name;
    private double price;
    private int honor;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getHonor() {
        return honor;
    }

    public void setHonor(int honor) {
        this.honor = honor;
    }
    public CaiPin(String name, double price, int honor) {
        this.name = name;
        this.price = price;
        this.honor = honor;
    }

    @Override
    public String toString() {
        return  caipinId +
                "\t" + name +
                "\t" + price +
                "\t" + honor;
    }
}
