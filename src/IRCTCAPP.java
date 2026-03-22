import java.util.List;
import java.util.Scanner;

public class IRCTCAPP {
    private final Scanner sc = new Scanner(System.in);
    public final UserService userService = new UserService();
    private final BookingService bookingService = new BookingService();

    public static void main(String a[]) {
        new IRCTCAPP().start();
    }

    public void start() {
        while(true)
        {
                System.out.println("-----------Welcome To IECTC------");
                if (!userService.isLoggedIn()) {
                    System.out.println("1.Register");
                    System.out.println("2.Login");
                    System.out.println("3.Exit");
                    System.out.println("Enter Your Choice:");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1 -> register();
                        case 2 -> login();
                        case 3 -> exit();
                        default -> System.out.println("Please Enter Valid choice");
                    }
                }
                else
                {
                    showUserMenu();
                }

        }
    }

    public void register() {
        System.out.println("Enter Your Name");
        String username = sc.next();

        System.out.println("Enter Your Password");
        String password = sc.next();

        sc.nextLine();
        System.out.println("Enter Your FullName");
        String fullname=sc.next();

        System.out.println("Enter Your Contact");
        String contact=sc.next();
        userService.registerUser(username,password,fullname,contact);

    }
    public void login()
    {
        System.out.println("Enter Your UserName");
        String username = sc.next();
        System.out.println("Enter Your Password");
        String password = sc.next();

        userService.loginUser(username,password);
    }
    public void showUserMenu()
    {
        if (userService.isLoggedIn())
        {
            System.out.println("User Menu");
            System.out.println("1.Search Trains ");
            System.out.println("2.Book Ticket");
            System.out.println("3.View My Ticket");
            System.out.println("4.Cancel My Ticket");
            System.out.println("5.View All Trains");
            System.out.println("6.Logged Out");
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1->searchTrain();
                case 2->bookTicket();
                case 3->viewMyTicket();
                case 4->cancelTicket();
                case 5->bookingService.listAllTrains();
                case 6->userService.logoutUser();
                default -> System.out.println("Invalid Choice");
            }
        }
    }
    public void searchTrain()
    {
        System.out.println("Enter Source");
        String source = sc.next();

        System.out.println("Enter Your Destination");
        String destination = sc.next();

        List<Train> train = bookingService.searchTrain(source,destination);
        if(train.isEmpty())
        {
            System.out.println("No Train Found Between"+source+"And"+destination);
            return;
        }
        System.out.println("Trains Found");
        for (Train trains:train)
        {
            System.out.println(trains);
        }
        System.out.println("Do You Want To Book A Ticket?(yes/no)");
        String choice=sc.next();

        if(choice.equalsIgnoreCase("yes"))
        {
            System.out.println("Enter Train Id To Booke Ticekt");
            int ticketId=sc.nextInt();

            System.out.println("Enter No Of Seat To Booke Ticekt");
            int seats=sc.nextInt();

            Ticket ticket=bookingService.bookTicket(userService.currentuser,ticketId,seats);
            if(ticket!=null)
            {
                System.out.println("ticket book successful");
                System.out.println(ticket);
            }

        }else {
            System.out.println("Returning to User Menu");
        }


    }
    private void bookTicket()
    {
        System.out.println("Enter Source");
        String source = sc.next();

        System.out.println("Enter Your Destination");
        String destination = sc.next();

        List<Train> train = bookingService.searchTrain(source,destination);
        if(train.isEmpty())
        {
            System.out.println("No Train Available For"+source+"And"+destination);
            return;
        }
        System.out.println("Available Trains");
        for (Train trains:train)
        {
            System.out.println(trains);
        }
        System.out.println("Enter Train Id To Booke Ticekt");
        int ticketId=sc.nextInt();

        System.out.println("Enter No Of Seat To Booke Ticekt");
        int seats=sc.nextInt();

        Ticket ticket=bookingService.bookTicket(userService.currentuser,ticketId,seats);
        if(ticket!=null)
        {
            System.out.println("ticket book successful");
            System.out.println(ticket);
        }

    }
    public void viewMyTicket()
    {
        List<Ticket> getTicketByUser=bookingService.getTicketByUser(userService.currentuser);
        if(getTicketByUser.isEmpty())
        {
            System.out.println("No Ticket Booked yet");
        }else
        {
            System.out.println("Tickets");
            for (Ticket ticket:getTicketByUser)
            {
                System.out.println(ticket);
            }
        }

    }
    private void cancelTicket()
    {
        System.out.println("Enter Ticekt to cancel ticket");
        int ticketId=sc.nextInt();
        bookingService.cancelTicket(ticketId,userService.currentuser);
    }
    public void exit()
    {
        System.out.println("Thank You For Using IRCTC");
        System.exit(0);
    }
}