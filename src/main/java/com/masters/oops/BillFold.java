package com.masters.oops;

/**
 * @author nikithaperumalla.
 * @id 87312
 */
public class BillFold {
    private Card card1;
    private Card card2;

    public void addCard(Card newCard){
        if(card1 == null){
            card1 = newCard;
        } else if(card2 == null){
            card2 = newCard;
        }
    }

    public String formatCards(){
        String formattedCard = "[";

        if(card1 != null){
            formattedCard = formattedCard + card1.format();
        }

        if(card2 != null){
            formattedCard = formattedCard + "|" + card2.format();
        }

        formattedCard = formattedCard + "]";
        return formattedCard;
    }
}
