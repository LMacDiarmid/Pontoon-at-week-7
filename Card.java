package Version3;

/**
 * <h1> Card class<h1>
 *<p> This creates each individual card </p>
 * @author Leanne
 * @since 24/10/2021
 **/

public class Card
{
    private Suit suit;
    private CardValue cardValue;

    /**
     * <h1>Card constructor</h1>
     * <p>Sets the cardValue and the suit</p>
     * @param cardValue - enum
     * @param suit -enum
     */
    public Card(CardValue cardValue, Suit suit)
    {
        setCardValue(cardValue);
        setSuit(suit);
    }

    public void setSuit(Suit suit)
    {
        this.suit = suit;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public void setCardValue(CardValue cardValue)
    {
        this.cardValue = cardValue;
    }

    public CardValue getCardValue()
    {
        return cardValue;
    }
}

