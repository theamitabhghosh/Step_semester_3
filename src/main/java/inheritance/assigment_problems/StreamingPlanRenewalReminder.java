package inheritance.assigment_problems;

import java.time.LocalDate;

abstract class StreamingPlan {

    protected LocalDate startDate;

    public StreamingPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends StreamingPlan {

    public BasicPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends StreamingPlan {

    public StandardPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends StreamingPlan {

    public PremiumPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {

        LocalDate startDate = LocalDate.of(2026, 1, 1);

        StreamingPlan[] plans = {
            new BasicPlan(startDate),
            new StandardPlan(startDate),
            new PremiumPlan(startDate)
        };

        for (StreamingPlan plan : plans) {

            LocalDate renewalDate = plan.calculateRenewalDate();

            if (plan instanceof BasicPlan) {
                System.out.println("BASIC: " + renewalDate);
            }
            else if (plan instanceof StandardPlan) {
                System.out.println("STANDARD: " + renewalDate);
            }
            else if (plan instanceof PremiumPlan) {
                System.out.println("PREMIUM: " + renewalDate);
            }
        }
    }
}