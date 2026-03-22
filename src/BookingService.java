import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {
   private List<Train> trainlist=new ArrayList<>();
    private List<Ticket> ticketlist=new ArrayList<>();

    public BookingService()
    {
        trainlist.add(new Train(101,"Vande Bharat","Pune","Mumbai",100));
        trainlist.add(new Train(102,"Rajdhani","Sambhajinagr","Mumbai",100));
        trainlist.add(new Train(103,"Mumbai","Nashik","Mumbai",100));
        trainlist.add(new Train(104,"Kotu","Nagar","Mumbai",100));
        trainlist.add(new Train(105,"Hydrabad","Baramati","Mumbai",100));
        trainlist.add(new Train(106,"Superfast","Jalna","Mumbai",100));

    }

    public List<Train> searchTrain(String source,String destination)
    {
        List<Train> res=new ArrayList<>();
        for (Train train:trainlist)
        {
            if(train.getSource().equalsIgnoreCase(source)&&train.getDestination().equalsIgnoreCase(destination))
            {
                res.add(train);

            }

        }
        return res;
    }
  public Ticket bookTicket(User user,int trainId,int seatCount)
    {
        for (Train train:trainlist)
        {
            if (train.getTranId()==trainId)
            {
                if (train.bookSeats(seatCount))
                {
                    Ticket ticket=new Ticket(trainId,train,user,seatCount);
                    ticketlist.add(ticket);
                    return ticket;
                }
                else {
                    System.out.println("Not enough seat");
                    return null;
                }
            }
        }
        System.out.println("Train Id Not Found");
        return null;
    }
    public List<Ticket> getTicketByUser(User user)
    {
        List<Ticket>res=new ArrayList<>();
        for (Ticket ticket:ticketlist)
        {
            if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
            {
                res.add(ticket);
            }
        }
        return res;
    }

  public boolean cancelTicket(int ticketId,User user)
  {
      Iterator<Ticket> iterator= ticketlist.listIterator();
      while (iterator.hasNext())
      {
          Ticket ticket=iterator.next();
          if(ticket.getTicketId()==ticketId &&
          ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
          {
              Train train=ticket.getTrain();
              train.cancelTicket(ticket.getSeatBooked());
              iterator.remove();
              System.out.println("Ticket"+ticketId+"Cancel Successfully");
              return true;
          }
      }
      System.out.println("Ticket does not belong to current user");
      return false;
  }
  public void listAllTrains()
  {
      System.out.println("ALL TRAINS");
      for (Train train:trainlist)
      {
          System.out.println(train);
      }
  }

    }



