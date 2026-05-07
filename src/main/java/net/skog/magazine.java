package net.skog;

public class Magazine extends Publication {
    private Integer issueNumber;
    private String category;
    private Integer publishedYear;

    public Magazine(String id, String title, boolean isAvailable, Integer issueNumber, String category,
            Integer publishedYear) {
        super(id, title, isAvailable);
        this.issueNumber = issueNumber;
        this.category = category;
        this.publishedYear = publishedYear;
    }

    public Integer getIssueNumber() {
        return issueNumber;
    }
    public String getCategory() {
        return category;
    }
    public Integer getPublishedYear() {
        return publishedYear;
    }

    @Override
    public String toString() {
        return "Magazine [issueNumber=" + issueNumber + ", category=" + category + ", publishedYear=" + publishedYear
                + ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", isAvailable()=" + isAvailable()
                + ", getIssueNumber()=" + getIssueNumber() + ", getCategory()=" + getCategory()
                + ", getPublishedYear()=" + getPublishedYear() + "]";
    }
}
