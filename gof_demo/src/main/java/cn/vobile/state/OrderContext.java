package cn.vobile.state;

/**
 * 对订单的直接操作
 */
public class OrderContext {

    private OrderState seatSuccessState;
    private OrderState cancelSeatState;
    private OrderState ticketOutState;
    private OrderState refundTicketState;

    OrderState state;

    public OrderContext(){
        this.seatSuccessState = new SeatSuccessState(this);
        this.cancelSeatState = new CancelSeatState(this);
        this.ticketOutState = new TicketOutState(this);
        this.refundTicketState = new RefundTicketState(this);

        state = seatSuccessState;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void holdSeat(){
        state.holdSeat();
    }

    public void cancelSeat(){
        state.cancelSeat();
    }

    public void ticketOut(){
        state.ticketOut();
        this.setState(ticketOutState);
    }

    public void refundTicket(){
        state.refundTicket();
        this.setState(seatSuccessState);
    }

    public void clearState(){
        this.setState(this.getSeatSuccessState());
    }

    public OrderState getSeatSuccessState() {
        return seatSuccessState;
    }

    public void setSeatSuccessState(OrderState seatSuccessState) {
        this.seatSuccessState = seatSuccessState;
    }

    public OrderState getCancelSeatState() {
        return cancelSeatState;
    }

    public void setCancelSeatState(OrderState cancelSeatState) {
        this.cancelSeatState = cancelSeatState;
    }

    public OrderState getTicketOutState() {
        return ticketOutState;
    }

    public void setTicketOutState(OrderState ticketOutState) {
        this.ticketOutState = ticketOutState;
    }

    public OrderState getRefundTicketState() {
        return refundTicketState;
    }

    public void setRefundTicketState(OrderState refundTicketState) {
        this.refundTicketState = refundTicketState;
    }

    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        orderContext.holdSeat();
        orderContext.cancelSeat();
        //清除状态重新开始
        orderContext.clearState();
        orderContext.ticketOut();
        orderContext.refundTicket();
    }
}
