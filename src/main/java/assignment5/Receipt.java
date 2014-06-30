package assignment5;


public class Receipt {
    private Customer customer;
    private double amountDue;
    private double amountPaid;
    private double changeDue;

    public Receipt(Customer customer, double amountPaid){
        this.customer = customer;
        this.amountPaid = amountPaid;
        this.amountDue = customer.getTotalCharge();
        this.changeDue = getChangeDue();
    }

    public Customer getCustomer() {
        return customer;
    }


    public double getAmountDue() {
        return amountDue;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getChangeDue() {
        changeDue = amountPaid - amountDue;
        return changeDue;
    }


    public void printReceipt(){
        StringBuilder receipt = new StringBuilder();
        receipt.append("\nReceipt for Video Rental Purchase:");
        receipt.append("\n__________________________________\n");
        receipt.append(customer.getStatement().statement());
        receipt.append("\n___________________________________\n");
        receipt.append("Total amount due: " + customer.getTotalCharge() + "\n");
        receipt.append("Total amount paid: " + amountPaid + "\n");
        receipt.append("Total change due: " + changeDue);

        System.out.println(receipt);
    }
}
