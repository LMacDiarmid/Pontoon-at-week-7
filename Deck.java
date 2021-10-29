package Version3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * <h1> Version3 - Deck <h1>
 * <p>This class is to define and manipulate the deck used for the game</p>
 * @author Leanne
 * @since 24/10/2021
 **/
public class Deck
{
    private  ArrayList deck = new ArrayList();

    /**
     * <h1>Deck constructor</h1>
     * <p>This constructor initialises the deck and then shuffles it</p>
     * <p>For loop to loop through each value of the CardValue enum (13 options different options)
     * <br>     the value variable of CardValue is then given the value of the CardValue enum at index i
     * <br>     Inner for loop that loops through each of the Suit enums (4 different options)
     * <br          the card is then initialised with the value variable and the suit enum at index j
     * <br>         the card is then added to the deck ArrayList
     * The deck is then shuffled eliminating the need to generate random numbers to choose a card</p>

     */
    public Deck()
    {
        for(int i = 0; i < 13; i++)
        {
            CardValue value = CardValue.values()[i]; //I need to go through this and fix the names because i'm confused

            for (int j = 0; j < 4; j++)
            {
                Card card = new Card( value, Suit.values()[j]);
                this.deck.add(card);
            }
        }
    }

    /**
     * <h1>shuffleDeck</h1>
     * <p>Shuffles the decks</p>
     */
    public void shuffleDeck()
    {
        Collections.shuffle(deck);
    }

    /**
     * <h1>cardIterator</h1>
     * <p>the iterator gives us the next card in the deck and then returns the card</p>
     * @return the card at the top of the array
     */
    public Card cardIterator()
    {
        Iterator cardIterator = deck.iterator();
        Card topCard = (Card) cardIterator.next();
        return topCard;
    }

    /**
     * <h1>drawCard</h1>
     * <p> calls the cardIterator method to get the card at the top of the deck and then store it in newCard,
     * the value is the output to the user and remove card is called </p>
     * @return newCard the card is returned
     */
    public Card drawCard()
    {
        Card newCard = cardIterator();
        removeCard();
        return newCard;

    }

    /**
     * <h1>removeCard</h1>
     * <p>removes the card that was at the top of the deck</p>
     */
    public void removeCard()
    {
        deck.remove(cardIterator());
    }

    /**
     * <h1>displayDeck</h1>
     * <p>displays the entire deck</p>
     */
    public void displayDeck()
    {
        Iterator cardIterator = deck.iterator();
        while(cardIterator.hasNext())
        {
            Card aCard = (Card) cardIterator.next();
            System.out.println(aCard.getCardValue() + " of " + aCard.getSuit());
        }

    }
}