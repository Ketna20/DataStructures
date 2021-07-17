package oopconcepts.vendingmachine;
/*
 * ketnakhalasi created on 7/17/21
 * */

import java.util.List;
import java.util.Map;

public class VendingMachine implements Selector {

    private final Inventory<Coin> coinInventory = new Inventory<>();
    private final Inventory<Item> itemInventory = new Inventory<>();

    private int totalSales;
    private int currentBalance;
    private Item currentItem;

    public VendingMachine() {
        initMachine();
    }

    private void initMachine() {
        System.out.println("Initializing vending machine with coins and items ...");
    }

    @Override
    public int checkPriceBtn(Item item) { return 0;}

    @Override
    public void insertCoinBtn(Coin coin) {}

    @Override
    public Map<Item, List<Coin>> buyBtn() {return null; }

    @Override
    public List<Coin> refundBtn() {return null;}

    @Override
    public void resetBtn() {}

    private Item collectItem() { return null; }

    private List<Coin> collectChange() { return null; }

    private boolean hasFullPaid() { return false; }

    private List<Coin> getChange(int amount) { return null; }

    private boolean hasSufficientChange() { return false; }
    private boolean hasSufficientChangeForAmount() { return false; }

    private void updateCoinInventory(List<Coin> coins) {}

    private void updateItemInventory(List<Item> items) {}

    public int getTotalSales() {
        return totalSales;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }
}
