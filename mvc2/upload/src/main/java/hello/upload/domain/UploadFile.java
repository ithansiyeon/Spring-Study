package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {

    private String uploadFileName;
    private String storeFileName;

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName; //고객
        this.storeFileName = storeFileName; //디렉토리에 저장되어 있는 것
    }
}
