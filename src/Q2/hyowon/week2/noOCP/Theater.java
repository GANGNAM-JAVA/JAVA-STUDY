package Q2.hyowon.week2.noOCP;


import java.util.HashMap;
import java.util.Map;

public class Theater {
    Money income;

    public Theater() {
        this.income = new Money(0);
    }

    public static void main(String[] args) {
        Theater megaBox = new Theater();

        Movie avatar = new Movie("avatar", 10000);
        Movie titanic = new Movie("titanic", 10000);

        Map<String, Integer> movieAudience = new HashMap();
        movieAudience.put("avatar", 3);
        movieAudience.put("titanic", 4);

        for (String movieName : movieAudience.keySet()) {
            megaBox.income.plus(titanic.enter(movieAudience.get(movieName)));
        }

        System.out.println("total amount is :" + megaBox.income.getAmount());
    }
}

// dicount를 OCP 지키지 않고 코딩
class Movie {
    String movieName;
    Money moviePrice;

    public Movie(String movieName, int price) {
        this.movieName = movieName;
        this.moviePrice = new Money(price);
    }

    int enter(int audienceCount) { // OCP를 위반. 할인정책이 추가, 변경될 때마다 코드가 늘어간다.
        if (movieName.equals("avatar")) {
            return new AmountDiscountPolicy(500).calculate(moviePrice) * audienceCount;
        } else {
            return new PercentDiscountPolicy(20).calculate(moviePrice) * audienceCount;
        }
    }

}

class Money {
    private int amount;

    Money (int amount) {
        this.amount = amount;
    }
    public void amountDiscount(int minusAmount) {
        this.amount -= minusAmount;
    }
    public void plus(int minusAmount) {
        this.amount += minusAmount;
    }
    public void percentDiscount(int percent){
        this.amount = (this.amount * (100 - percent)) / 100;
    }
    public int getAmount() {
        return amount;
    }
}

class AmountDiscountPolicy {
    int discountAmount;

    public AmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    int calculate(Money moviePrice) {
        Money discountedPrice = new Money(moviePrice.getAmount());
        discountedPrice.amountDiscount(discountAmount);
        return discountedPrice.getAmount();
    }

}
class PercentDiscountPolicy {
    int discountPercent;
    PercentDiscountPolicy(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int calculate(Money moviePrice) {
        Money discountedPrice = new Money(moviePrice.getAmount());
        discountedPrice.percentDiscount(discountPercent);
        return discountedPrice.getAmount();
    }
}