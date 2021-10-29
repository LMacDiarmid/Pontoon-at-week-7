package Version3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1> Game </h1>
 * <p> The game is created and run through here </p>
 *
 * @author Leanne
 * @version 3
 * @since 27/10/2021
 */
public class Game
{
    private int gameLimit;
    private int gamesWon; // Need to use this


    /**
     * <h1> Constructor for Game</h1>
     * <p>this constructor makes and runs the game</p>
     */
    public Game()
    {
        MyFormat format = new MyFormat();

        format.lineBreak();
        System.out.println("\nPontoon");
        format.lineBreak();

        setGameLimit();
        format.lineBreak();

       for(int game =0; game < gameLimit; game++) {
           Deck deck = new Deck();
           deck.shuffleDeck();
           Player p1 = new Player();

           Card card1 = deck.drawCard();
           p1.addToCardTotal(card1);
           Card card2 = deck.drawCard();
           p1.addToCardTotal(card2);
           Card newCard;

           System.out.println("Game: " + (game + 1));

           System.out.println("You drew " + card1.getCardValue() + " of " + card1.getSuit() + " and " + card2.getCardValue() + " of " + card2.getSuit());

           while (format.getUserInput("Would you like to draw another, y/n?" , false).equalsIgnoreCase("y"))
           {
               newCard = deck.drawCard();
               p1.addToCardTotal(newCard);
               System.out.println("You drew "+ newCard.getCardValue() +" of "+newCard.getSuit());
           }

           int total = p1.getCardTotal();
           System.out.println("Your total is :"+total);

           //Now the house draws

           Player house = new Player();
           Card houseCard1 = deck.drawCard();
           house.addToCardTotal(houseCard1);

           Card houseCard2 = deck.drawCard();
           house.addToCardTotal(houseCard2);

           int houseTotal = house.getCardTotal();


           displayResults(total, houseTotal);
           p1.displayDrawnCards();

           format.lineBreak();
           //deck.displayDeck();


       }
       format.lineBreak();
       System.out.println("The percentage of games won: "+gamePercentage());

       System.out.println("GoodBye");


    }

    /**
     * <h1>setGameLimit</h1>
     * <p>Asks the user how many games they want to play</p>
     */
    private void setGameLimit()
    {
        Scanner kboard = new Scanner(System.in);
        System.out.println("How many games would you like to play?");
        gameLimit = kboard.nextInt();

    }

    /**
     * <h1>getResult</h1>
     * <p>Gets the result of the game and returns true or false</p>
     * @param userTotal total
     * @param houseTotal house total
     * @return if userTotal is more than houseTotal and less than 21 returns true if not returns false
     */
    public boolean getResult(int userTotal, int houseTotal) {
        return userTotal > houseTotal && userTotal <= 21;
    }

    /**
     * <h1>busted</h1>
     * <p>checks to see if the parameter is more then 21</p>
     * @param userTotal - checks the users result
     * @return if the param is more than 21 return true
     */
    public boolean busted(int userTotal) {
        return userTotal > 21;
    }



    /**
     * <h1> displayResults</h1>
     * <p> takes in the players userTotal as well as the houses userTotal and the arraylist of drawn cards
     * <br>then outputs them to the owner depending on the results of the game</p>
     * @param userTotal the users calculated userTotal
     * @param houseTotal the houses userTotal
     */
    public void displayResults(int userTotal, int houseTotal)
    {
        if ((getResult(userTotal, houseTotal)) || (busted(houseTotal) && userTotal<=21)) {
            System.out.println("You have won! Congratulations!");
            if(busted(houseTotal))
            {
                System.out.print("The house busted with "+houseTotal);

            }
            else
            {
                System.out.println("The house lost with "+houseTotal);
            }
            gamesWon++;
        } else if (busted(userTotal)) {
            System.out.println("Busted! Your cards userTotal " + userTotal + " which is over 21");

        } else
        {
            if (userTotal == houseTotal)
            {
                System.out.println("Your userTotal was "+userTotal+" and the house had "+ houseTotal + "The game was a draw, so the house has won!") ;
            }
            System.out.println("You have lost with " + userTotal + " the house has " + houseTotal + "!");
        }
    }

    /**
     * <h1>gamePercentage</h1>
     * <p>calculates the percentage of games won</p>
     * @return
     */
    public double gamePercentage()
    {
        return ((100/gameLimit)*gamesWon);
    }

    /**
     * <h1>Display Statistic</h1>
     * <p> takes in the gamePercentage and the statistics string and displays the details</p>
     * @param gamePercentage - the percentage of games won
     * @param statistics - the frequency of cards drawn
     */
    public void displayStatistics(double gamePercentage, String[] statistics)
    {
        System.out.println("Number of games won: " + gamePercentage + "%");

        System.out.println("Histogram showing frequency of each card drawn");

        for (int i = 0; i < statistics.length; i++) {
            System.out.println(i + 1 + " " + statistics[i]);

        }


    }

}
