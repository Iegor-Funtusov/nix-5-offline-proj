package ua.davidenko.authors;

public class Authors {
    private String authorName;
    private String authorId;

    public Authors(String authorName, String authorId) {
        this.authorName = authorName;
        this.authorId = authorId;
    }

    public Authors() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "authorName='" + authorName + '\'' +
                ", authorId='" + authorId + '\'' +
                '}';
    }
}
