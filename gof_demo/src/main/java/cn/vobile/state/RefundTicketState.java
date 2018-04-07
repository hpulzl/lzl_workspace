package cn.vobile.state;

public class RefundTicketState implements OrderState {

    OrderContext orderContext;

    public RefundTicketState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    public void holdSeat() {
        printDesc("已经退票，无法占座...");
    }

    @Override
    public void cancelSeat() {
        printDesc("已经退票，无法取消...");
    }

    public void ticketOut() {
        printDesc("已经退票，无法再次出票，请重新购票...");
    }

    public void refundTicket() {

        printDesc("已经为您退票，不能重复此操作");
    }
}
