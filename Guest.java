public class Guest extends Person {

    private String email;
    private int discount;

    public Guest(int id, String name, String email, int discount) {
        super(id, name);
        this.email = email;
        this.discount = discount;
    }

    public String getEmail() { return email; }
    public int getDiscount() { return discount; }

    public void setEmail(String email) { this.email = email; }
    public void setDiscount(int discount) { this.discount = discount; }

    @Override
    public void printDetails() {
        System.out.println(id + " | " + name + " | " + email + " | Discount: " + discount);
    }
}