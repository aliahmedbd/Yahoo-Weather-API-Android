package aliahmed.info.yahooweatherapi.weather;

import android.graphics.Bitmap;

public class ImageListModel {
    public Bitmap bitmap;
    public String name;
    public String path;
    public String uri;
    public boolean isUploaded;
    public boolean isAlpha;
    public int attachmentId;
    public boolean isFailedToUpload;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isUploaded() {
        return isUploaded;
    }

    public void setUploaded(boolean uploaded) {
        isUploaded = uploaded;
    }

    public boolean isAlpha() {
        return isAlpha;
    }

    public void setAlpha(boolean alpha) {
        isAlpha = alpha;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    public boolean isFailedToUpload() {
        return isFailedToUpload;
    }

    public void setFailedToUpload(boolean failedToUpload) {
        isFailedToUpload = failedToUpload;
    }
}
