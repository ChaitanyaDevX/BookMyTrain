public class Train {
    int tranId;
    String name;
    String source;
    String destination;
    int totalseats;
    int availableseats;

    public Train(int tranId, String name, String source, String destination, int totalseats) {
        this.tranId = tranId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.totalseats = totalseats;
        this.availableseats = totalseats;
    }

    public int getTranId() {
        return tranId;
    }

    public void setTranId(int tranId) {
        this.tranId = tranId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(int totalseats) {
        this.totalseats = totalseats;
    }

    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }

    public boolean bookSeats(int count)
    {
        if(count<=availableseats) {
            availableseats -=count;
            return true;

        }
        return false;
    }
    public void cancelTicket(int count)
    {
        availableseats+=count;

    }

    @Override
    public String toString() {
        return tranId+"|"+name+"|"+source+"-->"+destination+"Available Seat"+availableseats;
    }
}
