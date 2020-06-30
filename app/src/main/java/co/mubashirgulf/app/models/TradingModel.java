package co.mubashirgulf.app.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TradingModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("all_record")
    @Expose
    private List<AllRecord> allRecord = null;
    @SerializedName("most_read")
    @Expose
    private List<AllRecord> mostRead = null;
    @SerializedName("latest_articles")
    @Expose
    private List<AllRecord> latestArticles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AllRecord> getAllRecord() {
        return allRecord;
    }

    public void setAllRecord(List<AllRecord> allRecord) {
        this.allRecord = allRecord;
    }

    public List<AllRecord> getMostRead() {
        return mostRead;
    }

    public void setMostRead(List<AllRecord> mostRead) {
        this.mostRead = mostRead;
    }

    public List<AllRecord> getLatestArticles() {
        return latestArticles;
    }

    public void setLatestArticles(List<AllRecord> latestArticles) {
        this.latestArticles = latestArticles;
    }

    public class AllRecord {

        @SerializedName("post_id")
        @Expose
        private String postId;
        @SerializedName("post_title")
        @Expose
        private String postTitle;
        @SerializedName("post_content")
        @Expose
        private String postContent;
        @SerializedName("post_date")
        @Expose
        private String postDate;
        @SerializedName("post_link")
        @Expose
        private String postLink;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("comment")
        @Expose
        private List<Comment> comment = null;

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getPostTitle() {
            return postTitle;
        }

        public void setPostTitle(String postTitle) {
            this.postTitle = postTitle;
        }

        public String getPostContent() {
            return postContent;
        }

        public void setPostContent(String postContent) {
            this.postContent = postContent;
        }

        public String getPostDate() {
            return postDate;
        }

        public void setPostDate(String postDate) {
            this.postDate = postDate;
        }

        public String getPostLink() {
            return postLink;
        }

        public void setPostLink(String postLink) {
            this.postLink = postLink;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<Comment> getComment() {
            return comment;
        }

        public void setComment(List<Comment> comment) {
            this.comment = comment;
        }

    }

    public class Comment {

        @SerializedName("comment_id")
        @Expose
        private String commentId;
        @SerializedName("comment_author")
        @Expose
        private String commentAuthor;
        @SerializedName("comment_author_email")
        @Expose
        private String commentAuthorEmail;
        @SerializedName("comment_author_url")
        @Expose
        private String commentAuthorUrl;
        @SerializedName("comment_content")
        @Expose
        private String commentContent;
        @SerializedName("comment_date")
        @Expose
        private String commentDate;

        public String getCommentId() {
            return commentId;
        }

        public void setCommentId(String commentId) {
            this.commentId = commentId;
        }

        public String getCommentAuthor() {
            return commentAuthor;
        }

        public void setCommentAuthor(String commentAuthor) {
            this.commentAuthor = commentAuthor;
        }

        public String getCommentAuthorEmail() {
            return commentAuthorEmail;
        }

        public void setCommentAuthorEmail(String commentAuthorEmail) {
            this.commentAuthorEmail = commentAuthorEmail;
        }

        public String getCommentAuthorUrl() {
            return commentAuthorUrl;
        }

        public void setCommentAuthorUrl(String commentAuthorUrl) {
            this.commentAuthorUrl = commentAuthorUrl;
        }

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentDate() {
            return commentDate;
        }

        public void setCommentDate(String commentDate) {
            this.commentDate = commentDate;
        }

    }

}