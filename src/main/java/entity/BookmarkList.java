package entity;

import java.util.ArrayList;
import java.util.List;

public class BookmarkList {
    private String name;
    private String description;
    private List<Bookmark> bookmarks;

    public BookmarkList(String name, String description) {
        this.name = name;
        this.description = description;
        this.bookmarks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public void addBookmark(Bookmark bookmark) {
        bookmarks.add(bookmark);
    }

    public boolean deleteBookmark(int i) {
        if (i >= 0 && i < bookmarks.size()) {
            bookmarks.remove(i);
            return true;
        }
        return false;
    }
}
