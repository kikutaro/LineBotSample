package xyz.kikutaro.line.bot.sendgrid;

import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.VideoMessage;
import com.linecorp.bot.model.message.template.ButtonsTemplate;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;
import java.util.Arrays;
import org.springframework.stereotype.Controller;

/**
 *
 * @author kikuta
 */
@Controller
public class SendGridBotController {
    
    public TemplateMessage menuMessage(String message) {
        return new TemplateMessage(message, new ButtonsTemplate(
                "https://sendgrid.kke.co.jp/blog/wp/wp-content/uploads/2016/09/SG_Logo_Blog-592x366.jpg"
                , message
                ,"必要な情報を以下からお選びください。",Arrays.asList(
                        new MessageAction("Webサイト", "Webサイト"),
                        new MessageAction("プランを確認する", "プラン"),
                        new MessageAction("動画をみる", "動画")
                )));
    }
    
    public TextMessage webSiteMessage() {
        return new TextMessage("こちらのURLをクリックしてください→ https://sendgrid.kke.co.jp/");
    }
    
    public TemplateMessage planMessage() {
        return new TemplateMessage("プラン", new CarouselTemplate(
            Arrays.asList(
                new CarouselColumn(null, "Free", "0円 12,000通/月", Arrays.asList(
                        new MessageAction("機能確認", "Free"),
                        new MessageAction("申込む", "申込む")
                    )
                ),
                new CarouselColumn(null, "Bronze", "1,180円/月 40,000通/月", Arrays.asList(
                        new MessageAction("機能確認", "Bronze"),
                        new MessageAction("申込む", "申込む")
                    )
                ),
                new CarouselColumn(null, "Silver", "9,480円/月 100,000通/月", Arrays.asList(
                        new MessageAction("機能確認", "Silver"),
                        new MessageAction("申込む", "申込む")
                    )
                ),
                new CarouselColumn(null, "Gold", "22,980円/月 300,000通/月", Arrays.asList(
                        new MessageAction("機能確認", "Gold"),
                        new MessageAction("申込む", "申込む")
                    )
                ),
                new CarouselColumn(null, "Platinum", "45,980円/月 700,000通/月", Arrays.asList(
                        new MessageAction("機能確認", "Platinum"),
                        new MessageAction("申込む", "申込む")
                    )
                )
            )
        ));
    }
    
    public VideoMessage movieMessage() {
        return new VideoMessage("https://vimeo.com/41433099", "https://sendgrid.kke.co.jp/blog/wp/wp-content/uploads/2016/09/SG_Logo_Blog-592x366.jpg");
    }
    
    public TextMessage applyMessage() {
        return new TextMessage("こちらのURLをクリックしてください→ https://sendgrid.kke.co.jp/app?p=signup.index");
    }
}
