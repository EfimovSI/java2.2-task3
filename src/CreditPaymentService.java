public class CreditPaymentService {
    public long calculate (long creditAmount, double percentRate, double periodYears) {
        //Точную формулу пришлось закомментить
        //double monthlyRate = Math.pow ((100 + percentRate) / 100.0, 1.0 / 12.0) - 1;
        //double annuityRatio = (monthlyRate * Math.pow (1.0 + monthlyRate, periodYears * 12.0)) / (Math.pow (1.0 + monthlyRate, periodYears * 12.0) - 1.0);
        //long monthlyPayment = (long) (creditAmount * annuityRatio);

        //Как выяснилось (из примеров), банки счичают по упрощенной формуле:
        long monthlyPayment = (long) (creditAmount * (percentRate/(12 * 100)) / (1 - Math.pow (1 + percentRate/(12*100), - periodYears * 12)));

        return monthlyPayment;
    }
}
