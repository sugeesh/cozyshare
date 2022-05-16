package io.cozyshare.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SharedFile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private Date startDate;

    private Date endDate;

    private String fileKey;

    @Lob
    private String redirectUrl;

    private String uuid;

    private int fileNumber;

    public SharedFile() {
    }

    public SharedFile(long id, Date startDate, Date endDate, String fileKey, String redirectUrl, String uuid, int fileNumber) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fileKey = fileKey;
        this.redirectUrl = redirectUrl;
        this.uuid = uuid;
        this.fileNumber = fileNumber;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(int fileNumber) {
        this.fileNumber = fileNumber;
    }

    @Override
    public String toString() {
        return "SharedFile{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", fileKey='" + fileKey + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", uuid='" + uuid + '\'' +
                ", fileNumber=" + fileNumber +
                '}';
    }
}
