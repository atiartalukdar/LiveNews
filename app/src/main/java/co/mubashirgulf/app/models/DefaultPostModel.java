package co.mubashirgulf.app.models;

import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class DefaultPostModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("post")
    @Expose
    private Post post;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public class Post {

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

    }
}