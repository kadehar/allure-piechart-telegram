package allure.piechart.telegram.templates.messenger.telegram;

import allure.piechart.telegram.templates.data.TemplateData;
import org.stringtemplate.v4.ST;

/**
 * Управляет созданием форматированного сообщения для отправки в telegram
 *
 * @author kadehar
 * @since 2.0.2
 */
public class Telegram {
    public static String tgMessage(final String locale, final TemplateData data) {
        ST template;
        switch (locale.toLowerCase()) {
            case "ru":
                template = TelegramRuTemplate.newInstance().message(data);
                format(template);
                return template.render();
            case "en":
                template = TelegramEngTemplate.newInstance().message(data);
                format(template);
                return template.render();
            default:
                throw new IllegalStateException("Unexpected value: " + locale.toLowerCase());
        }
    }

    private static void format(ST template) {
        template.add("bullet", '\u2022');
        template.add("open_bold", "<b>");
        template.add("close_bold", "</b>");
    }
}
