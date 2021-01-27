package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.dashboard.FinancialOverview;

public class OverviewData {

    public static Question<String> creditAvaible(){
        return actor -> TextContent.of(FinancialOverview.CREDIT_AVAILABLE).viewedBy(actor).asString().trim();
    }
    public static Question<String> totalBalance(){
        return actor -> TextContent.of(FinancialOverview.TOTAL_BALANCE).viewedBy(actor).asString().trim();
    }
}
