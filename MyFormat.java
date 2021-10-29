package Version3;

import java.util.Scanner;

/**
 * <h1> My Format <h1>
 *     <p> This class is used to hold my frequently used code</p>
 * @author leanne
 * @since 23/10/2021
 **/
public class MyFormat
{

    public MyFormat()
    {

    }


    /**
     * <h1>getUserInput</h1>
     * <p>Asks the user a question that is passed through and returns the user response</p>
     * <p> if the closeScanner is true the scanner will be closed and method ended</p>
     * <p>This method was chosen to avoid repetition of code</p>
     * @param question the question that needs to be shown to the user
     * @param closeScanner if this is equal to true the scanner will close
     * @return the user response
     */
    public String getUserInput(String question, boolean closeScanner)
    {
        Scanner kboard = new Scanner(System.in);
        if (closeScanner)
        {
            kboard.close();
            return null;
        }
        else
        {
            System.out.println(question);
            return kboard.nextLine();
        }
    }


    /**
     * <h1>Linebreak</h1>
     * <p>This outputs a linebreak</p>
     */
    public void lineBreak()
    {
        System.out.println("_________________________________________________________________________________");
    }
}
