package template;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        IPaymentFlow payAFriend = new PayToFriend();
        payAFriend.sendMoney();
        System.out.println();
        IPaymentFlow payMerchant = new PayToMerchant();
        payMerchant.sendMoney();

    }
}
