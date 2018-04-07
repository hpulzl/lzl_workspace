package cn.vobile.state;

public class SeatSuccessState implements OrderState {

    OrderContext orderContext;

    public SeatSuccessState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    public void holdSeat() {
        printDesc("占座成功...");
    }

    @Override
    public void cancelSeat() {
        printDesc("正在为您取消占座...");
        orderContext.setState(orderContext.getCancelSeatState());
    }

    public void ticketOut() {
        printDesc("正在为您申请出票...");
        orderContext.setState(orderContext.getTicketOutState());
    }

    public void refundTicket() {
        printDesc("您当前占座成功，但是还未出票...");
    }
}
