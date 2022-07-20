
package kata5p2view;

import java.util.List;
import kata5p2model.Mail;
import kata5p2model.Histogram;

public class MailHistogramBuilder {
    public static Histogram build(List<Mail> mailList){
        Histogram<String> histogram = new Histogram();
        for (Mail mail : mailList) {
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
}
