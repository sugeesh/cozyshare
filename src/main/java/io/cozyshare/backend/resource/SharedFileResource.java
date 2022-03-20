package io.cozyshare.backend.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.cozyshare.backend.model.SharedFile;
import io.cozyshare.backend.util.DateTimeUtil;

public class SharedFileResource {

    private int id;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("end_date")
    private String endDate;

    @JsonProperty("file_key")
    private String fileKey;

    public SharedFileResource() {
    }

    public SharedFileResource(int id, String startDate, String endDate, String fileKey) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fileKey = fileKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    @Override
    public String toString() {
        return "FileShareResource{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", fileKey='" + fileKey + '\'' +
                '}';
    }

    public SharedFile toFileModel() {
        SharedFile sharedFile = new SharedFile();
        sharedFile.setFileKey(this.fileKey);
        sharedFile.setStartDate(DateTimeUtil.getDateByString(this.startDate));
        sharedFile.setEndDate(DateTimeUtil.getDateByString(this.endDate));
        return sharedFile;
    }
}
