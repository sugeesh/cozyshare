package io.cozyshare.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class SharedFile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private Date startDate;

    private Date endDate;

    private String fileKey;

    private String redirectUrl;

    public SharedFile() {
    }

    public SharedFile(long id, Date startDate, Date endDate, String fileKey) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fileKey = fileKey;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }


    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }


    @Override
    public String toString() {
        return "SharedFile{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", fileKey='" + fileKey + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
    }
}
