package xyz.kikutaro.line.bot;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.AudioMessageContent;
import com.linecorp.bot.model.event.message.ImageMessageContent;
import com.linecorp.bot.model.event.message.StickerMessageContent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.event.message.VideoMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xyz.kikutaro.line.bot.sendgrid.SendGridBotController;

@SpringBootApplication
@LineMessageHandler
public class LineBotSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LineBotSampleApplication.class, args);
    }
    
    @Autowired
    private SendGridBotController sgCtrl;
    
    @EventMapping
    public Message handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        System.out.println("event: " + event);
        
        switch(event.getMessage().getText()) {
            case "Webサイト" :
                return sgCtrl.webSiteMessage();
            case "プラン" :
                return sgCtrl.planMessage();
            case "動画":
                return sgCtrl.movieMessage();
            case "申込む" :
                return sgCtrl.applyMessage();
            case "Free" :
            case "Bronze" :
            case "Silver" :
            case "Gold" :
            case "Platinum" :
                return new TextMessage("機能表示ってどういうUIがいいんですかねー");
        }
        
        return sgCtrl.menuMessage("「" + event.getMessage().getText() +"」とメッセージいただき、ありがとうございます！");
    }
    
    @EventMapping
    public Message handleFollowEvent(FollowEvent event) {
        return sgCtrl.menuMessage("友達追加ありがとうございます！");
    }
    
    @EventMapping
    public Message handleStickerMessage(MessageEvent<StickerMessageContent> event) {
        return sgCtrl.menuMessage("スタンプ送信ありがとうございます！");
    }
    
    @EventMapping
    public Message handleImageMessage(MessageEvent<ImageMessageContent> event) {
        return sgCtrl.menuMessage("画像送信ありがとうございます！");
    }
    
    @EventMapping
    public Message handleVideoMessage(MessageEvent<VideoMessageContent> event) {
        return sgCtrl.menuMessage("動画送信ありがとうございます！");
    }
    
    @EventMapping
    public Message handleAudioMessage(MessageEvent<AudioMessageContent> event) {
        return sgCtrl.menuMessage("音声送信ありがとうございます！");
    }
    
    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}
