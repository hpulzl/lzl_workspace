package cn.vobile.state;

public class TicketOutState implements OrderState {

    OrderContext orderContext;

    public TicketOutState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    public void holdSeat() {
        printDesc("已经出票，无法占座...");
    }

    @Override
    public void cancelSeat() {
        printDesc("已经出票，无法取消...");
    }

    public void ticketOut() {
        printDesc("出票成功");
    }

    public void refundTicket() {
        printDesc("申请退票");
        orderContext.setState(orderContext.getRefundTicketState());
    }
}
