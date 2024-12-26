package src.Games;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck{

    private ArrayList<String> deck = new ArrayList<>();
    private ArrayList<String> shuffledDeck = new ArrayList<>();
    private ArrayList<String> player = new ArrayList<>();
    private ArrayList<String> splitPlayer = new ArrayList<>();
    private ArrayList<String> dealer = new ArrayList<>();
    private int playerValue;
    private int splitPlayerValue;
    private int dealerValue;
    private boolean sufficientCards;
    private String[] suits = {"Diamonds", "Spades", "Clubs", "Hearts"};
    private String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private boolean cardsEqual;

    // Constructor: Create and fill the deck
    public Deck() {
        for (String suit : suits) {
            for (String card : cards) {
                deck.add(suit + " " + card);
            }
        }
    }

    public void shuffleDeck() {
        this.shuffledDeck = new ArrayList<>(deck);
        Collections.shuffle(this.shuffledDeck);
        this.sufficientCards = false;
    }

    public void calculateValue() {
        this.playerValue = calculateHandValue(this.player);
        this.dealerValue = calculateHandValue(this.dealer);

        if (!splitPlayer.isEmpty()) {
            this.splitPlayerValue = calculateHandValue(this.splitPlayer);
        }
    }

    int calculateHandValue(ArrayList<String> hand) {
        int total = 0;
        int aceCount = 0;

        for (String card : hand) {
            String cardValue = card.split(" ")[1];

            if (cardValue.equals("J") || cardValue.equals("Q") || cardValue.equals("K")) {
                total += 10;
            } else if (cardValue.equals("A")) {
                aceCount++;
                total += 11;
            } else {
                total += Integer.parseInt(cardValue);
            }
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public boolean hasSufficientCards() {
        return this.sufficientCards;
    }

    public void dealCard(ArrayList<String> hand) {
        Random rand = new Random();
        int index = rand.nextInt(shuffledDeck.size());
        String card = shuffledDeck.remove(index);
        hand.add(card);

        if (shuffledDeck.size() <= 12) {
            this.sufficientCards = true;
        }
    }

    public void splitCard(ArrayList<String> hand) {
        String lastCard = hand.get(hand.size() - 1);
        String secondLastCard = hand.get(hand.size() - 2);

        String lastCardValue = lastCard.split(" ")[1];
        String secondLastCardValue = secondLastCard.split(" ")[1];

        if (lastCardValue.equals(secondLastCardValue)) {
            hand.remove(hand.size() - 1);
            String temp = hand.get(hand.size() - 1);
            splitPlayer.add(temp);
        }
    }

    public void checkCardsEqual(ArrayList<String> hand) {
        String lastCard = hand.get(hand.size() - 1);
        String secondLastCard = hand.get(hand.size() - 2);

        String lastCardValue = lastCard.split(" ")[1];
        String secondLastCardValue = secondLastCard.split(" ")[1];

        if (lastCardValue.equals(secondLastCardValue)) {
            this.cardsEqual = true;
        } else {
            this.cardsEqual = false;
        }
    }

    public ArrayList<String> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<String> deck) {
        this.deck = deck;
    }

    public ArrayList<String> getShuffledDeck() {
        return shuffledDeck;
    }

    public void setShuffledDeck(ArrayList<String> shuffledDeck) {
        this.shuffledDeck = shuffledDeck;
    }

    public ArrayList<String> getPlayer() {
        return player;
    }

    public void setPlayer(ArrayList<String> player) {
        this.player = player;
    }

    public ArrayList<String> getSplitPlayer() {
        return splitPlayer;
    }

    public void setSplitPlayer(ArrayList<String> splitPlayer) {
        this.splitPlayer = splitPlayer;
    }

    public ArrayList<String> getDealer() {
        return dealer;
    }

    public void setDealer(ArrayList<String> dealer) {
        this.dealer = dealer;
    }

    public int getPlayerValue() {
        return playerValue;
    }

    public void setPlayerValue(int playerValue) {
        this.playerValue = playerValue;
    }

    public int getSplitPlayerValue() {
        return splitPlayerValue;
    }

    public void setSplitPlayerValue(int splitPlayerValue) {
        this.splitPlayerValue = splitPlayerValue;
    }

    public int getDealerValue() {
        return dealerValue;
    }

    public void setDealerValue(int dealerValue) {
        this.dealerValue = dealerValue;
    }

    public String[] getSuits() {
        return suits;
    }

    public void setSuits(String[] suits) {
        this.suits = suits;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }

    public void showCards() {
        System.out.print("Dealer's Cards: ");
        System.out.print(dealer.get(0) + "--");
        System.out.print("X");
        System.out.println("\n-------------------------\n");

        System.out.print("Player's Cards: ");
        for (String card : player) {
            System.out.print(card + " ");
        }

        if (!splitPlayer.isEmpty()) {
            System.out.print("\nPlayer's Split Cards: ");
            for (String card : splitPlayer) {
                System.out.print(card + " ");
            }
        }
        System.out.println("\n-------------------------\n");
    }

    public void showFinalCards() {
        System.out.print("Dealer's Cards: ");
        for (String card : dealer) {
            System.out.print(card + "--");
        }
        System.out.println("\n-------------------------\n");

        System.out.print("Player's Cards: ");
        for (String card : player) {
            System.out.print(card + "  ");
        }

        if (!splitPlayer.isEmpty()) {
            System.out.print("\nPlayer's Split Cards: ");
            for (String card : splitPlayer) {
                System.out.print(card + "   ");
            }
        }
        System.out.println("\n-------------------------\n");
    }

    public void reset() {
        player.clear();
        splitPlayer.clear();
        dealer.clear();

        playerValue = 0;
        splitPlayerValue = 0;
        dealerValue = 0;
        sufficientCards = false;
        cardsEqual = false;
    }

    public boolean areCardsEqual() {
        return cardsEqual;
    }

    public void setCardsEqual(boolean cardsEqual) {
        this.cardsEqual = cardsEqual;
    }
}
