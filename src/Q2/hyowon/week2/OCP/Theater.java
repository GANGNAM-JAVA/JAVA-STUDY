package Q2.hyowon.week2.OCP;

import java.util.HashMap;
import java.util.Map;

// OCP를 적용한 코드
public class Theater {
    Money income;

    Theater() {
        this.income = new Money(0);
    }

    public static void main(String[] args) {
        Theater cgv = new Theater();

        Movie avatar = new Movie("avatar", 10000, new AmountDiscountPolicy(500));
        Movie titanic = new Movie("titanic", 10000, new PercentDiscountPolicy(20));

        Map<String, Integer> movieAudience = new HashMap();
        movieAudience.put("avatar", 3);
        movieAudience.put("titanic", 4);

        for (String movieName : movieAudience.keySet()) {
            cgv.income.plus(titanic.enter(movieAudience.get(movieName)));

        }
        System.out.println("total amount is :" + cgv.income.getAmount());
    }

}

class Movie {
    private String movieName;
    private Money moviePrice;
    private DiscountPolicy discountPolicy;
    
    Movie(String movieName, int price, DiscountPolicy discountPolicy) {
        this.movieName = movieName;
        this.moviePrice = new Money(price);
        this.discountPolicy = discountPolicy;
    }
    
    int enter(int audienceCount) {
        return discountPolicy.calculate(moviePrice) * audienceCount;
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

interface DiscountPolicy {
    int calculate(Money moviePrice);
}

class AmountDiscountPolicy implements DiscountPolicy {
    private int discountAmount;

    AmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int calculate(Money moviePrice) {
        Money discountedPrice = new Money(moviePrice.getAmount());
        discountedPrice.amountDiscount(discountAmount);
        return discountedPrice.getAmount();
    }
}
class PercentDiscountPolicy implements DiscountPolicy{
    private int discountPercent;

    PercentDiscountPolicy(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int calculate(Money moviePrice) {
        Money discountedPrice = new Money(moviePrice.getAmount());
        discountedPrice.percentDiscount(discountPercent);
        return discountedPrice.getAmount();
    }
}