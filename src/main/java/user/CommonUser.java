package user;

import bookmark.BookmarkList;

import java.util.ArrayList;
import java.util.List;

public class CommonUser extends User{
    private List<BookmarkList> bookmarkLists;

    public CommonUser(String username, String description) {
        super("CommonUser", username, description);
        this.bookmarkLists = new ArrayList<>();
    }

    public List<BookmarkList> getBookmarkLists() {
        return bookmarkLists;
    }

    public void setBookmarkLists(List<BookmarkList> bookmarkLists) {
        this.bookmarkLists = bookmarkLists;
    }

    public void createList(String name, String description) {
        bookmarkLists.add(new BookmarkList(name, description));
    }

    public boolean deleteList(int i) {
        if (i >= 0 && i < bookmarkLists.size()) {
            bookmarkLists.remove(i);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "usertype='" + usertype + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

}
