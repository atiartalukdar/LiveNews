package co.livenews.app.models;
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
    private List<MostRead> mostRead = null;
    @SerializedName("latest_articles")
    @Expose
    private List<LatestArticle> latestArticles = null;

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

    public List<MostRead> getMostRead() {
        return mostRead;
    }

    public void setMostRead(List<MostRead> mostRead) {
        this.mostRead = mostRead;
    }

    public List<LatestArticle> getLatestArticles() {
        return latestArticles;
    }

    public void setLatestArticles(List<LatestArticle> latestArticles) {
        this.latestArticles = latestArticles;
    }



    public class MostRead {

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
        @SerializedName("image")
        @Expose
        private String image;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    }

    public class LatestArticle {

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
        @SerializedName("image")
        @Expose
        private String image;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

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
        @SerializedName("image")
        @Expose
        private String image;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    }
}
