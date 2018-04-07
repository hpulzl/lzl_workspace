package cn.vobile.state;

public class CancelSeatState implements OrderState {
    OrderContext orderContext;

    public CancelSeatState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    public void holdSeat() {
        printDesc("已经取消，无法占座");
    }

    @Override
    public void cancelSeat() {
        if (orderContext.getState() instanceof CancelSeatState){
            printDesc("已取消!");
        }else{
            printDesc("不是占座成功状态，不能取消。");
        }
    }

    public void ticketOut() {
        printDesc("取消状态，无法出品...");
    }

    public void refundTicket() {
        printDesc("取消状态，无法退票...");
    }
}
