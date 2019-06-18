/*
 * adds several customers to the queue and simulates the server that attends 
   to the first customer in line every 4 seconds until all the customers
   are serveds.
 * 
 * 
 */
package icecreamqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author CPP and Antony Jones.
 */
public class IceCreamQueue {
    
    public static Queue<String> clientInQueue = new LinkedList();
    public static String clientArrivalTime;
    public static int placeInQueue = 0;
    
    
     /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        newClients();

        Timer clock = new Timer();

        /*timed event - first customer in line to 
        be seen, if there are any customers.*/

        clock.schedule(new IceCreamService(), 0, 4000);

    }//End of Main Method

    public static void newClients(){

        for (int inc=1; inc<5; inc++){

            clientInQueue.add("(Client Ticket: " + inc + ") ");

        }
        
    }//End of newClients Method
    
    
    /* Add a new inner class within the main class.This inner class 
    will hold a list of actions to repeat for ice cream serving.*/
    public static class IceCreamService extends TimerTask {
    
    /*Add code to the run() method of the inner class 
        to simulate customer being served:*/
        
        @Override
        public void run (){
          
            //print out message.
            System.out.println("Customer attendant is ready to"
                    + " serve the next Customer ");
            
            /*use of if statement to check if queue is empty via 
            .isEmpty function from library.*/
            if (clientInQueue.isEmpty()) {
                
                //Print out below message if no customers in queue.
                System.out.println("Currently no customers to see.\n");
                
                //Exit system set to 0.
                System.exit(0);
                
            }
                   
            //else if statement to check the clientInQueue is equal to 1.
            else if (clientInQueue.size() ==1) {
                System.out.println("Client with ticket number: "
                        + clientInQueue.poll()
                        + " is currently being served.\n");
                
                //Print out no more clients to be seen
                System.out.println("There are no more clients to see.\n");
            }
            
            /*else print the client currently being served 
            via clientInQueue.poll()*/
            else {
                
                /*Print out Client ticket number with customerQueue.poll()
                removes client in the queue from the top. Or show null
                if none and show the next client to be seen.*/
                System.out.println("Client with ticket number: " +
                        clientInQueue.poll() + " is next in line to be served!");
                
                //print out when queue is empty.
                System.out.println("Clients with the these tickets are in "
                        + "the queue: " + clientInQueue.toString() + "\n");

                
            }
         
        }//End of Run Method
        
    }//End of IceCreamService Inner Class
   
}//End of IceCreamQueue class