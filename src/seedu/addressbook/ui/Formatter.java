package seedu.addressbook.ui;

import java.util.ArrayList;
import java.util.List;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    static String formatMessage(String message, Object ...arg) {
        return String.format(message, arg);
    }

    static String addLinePrefix(String message){
        return LINE_PREFIX + message;
    }

    static List<String> formatMessages(String[] messages) {
        List<String> formattedMessages = new ArrayList<>();
        for (String m : messages) {
            formattedMessages.add(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }

        return formattedMessages;
    }

    /** Formats a list of strings as a viewable indexed list. */
    static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return formatMessage(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
