package cn.vobile.state;

/**
 *订单状态流转前的动作
 */
public interface OrderState {

    /**
     *占座
     */
    void holdSeat();

    /**
     * 占座成功，才能取消占座
     */
    void cancelSeat();
    /**
     * 出票
     */
    void ticketOut();

    /**
     * 退票
     */
    void refundTicket();

    default void printDesc(String str){
        System.out.println(str);
    }
}
