package Version3;

import java.util.ArrayList;

/**
 * <h1> User </h1>
 * <p> The User holds their cards  </p>
 *
 * @author Leanne
 * @version 2
 * @since 27/10/2021
 */
public class Player
{
    ArrayList<Card> cardsDrawn = new ArrayList<Card>();
    private int cardTotal;

    public Player()
    {

    }

    public int getCardTotal()
    {
        return cardTotal;
    }

    public ArrayList<Card> getCardsDrawn()
    {
        return cardsDrawn;
    }


    /**
     * <h1>addToCardTotal</h1>
     * <p>adds the card value to the cardTotal</p>
     * @param card the card that was drawn
     */
    public void addToCardTotal(Card card)
    {
        int temp = card.getCardValue().getCardValue();
        cardTotal = cardTotal + temp;
        addToDrawnCards(card);
    }

    /**
     * <h1>addToDrawnCards</h1>
     * <p>adding the cards that have been drawn to the array </p>
     * @param card the card that was drawn
     */
    public void addToDrawnCards(Card card)
    {
        cardsDrawn.add(card);

    }

    public void displayDrawnCards()
    {
        System.out.println("Cards drawn: ");
        for(int i = 0; i < cardsDrawn.size(); i++) {
            System.out.println(cardsDrawn.get(i).getCardValue() + " of " + cardsDrawn.get(i).getSuit());
        }
    }



}
