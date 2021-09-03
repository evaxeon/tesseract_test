import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.response.GetFileResponse;
import com.pengrad.telegrambot.response.SendResponse;

public class TelegramTest {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("1973421485:AAHuiDhX63Z42vAxsLTd2WR3N4V3LQftjL4");
        // Register for updates
        bot.setUpdatesListener(updates -> {
            // ... process updates
            // return id of last processed update or confirm them all
            for(Update upd : updates) {
                System.out.println(upd.message().text());
                System.out.println(upd.message().messageId());
                if(upd.message().photo() != null) {
                    GetFile request = new GetFile(upd.message().photo()[upd.message().photo().length - 1].fileId());
                    GetFileResponse getFileResponse = bot.execute(request);
                    File file = getFileResponse.file();
                    String fullPath = bot.getFullFilePath(file);
                    System.out.println(fullPath);
                }


            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

    }
}
