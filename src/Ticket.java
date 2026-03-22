public class Ticket {
    private int ticketId;
    private static int counter=1001;
    private Train train;
    private User user;
    private int seatBooked;

    public Ticket(int ticketId, Train train, User user, int seatBooked) {
        this.ticketId = counter++;
        this.train = train;
        this.user = user;
        this.seatBooked = seatBooked;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        this.seatBooked = seatBooked;
    }

    @Override
    public String toString() {
        return "TicketId:"+ticketId+"|Trian:"+train.getName()+"|Route"+ train.getSource()+"-->"+train.getDestination()+"|Seats:"+seatBooked+"|Booked By"+user.getFullname();
    }
}

