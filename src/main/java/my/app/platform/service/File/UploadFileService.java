package my.app.platform.service.File;

import my.app.platform.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 15:43
 *         创建说明：上传文件服务
 */

@Service
public class UploadFileService {
    @Value("${upload.file.path}")
    private String path;

    /**
     * 图片上传
     * @param file 文件
     * @param username 商家id
     * @return 是否上传成功
     */
    public String uploadPic(MultipartFile file, String username){
        if (!file.isEmpty()) {
            try {
                String folderPath = path + username + "/";

                //如果路径不存在，则创建
                File newFile = new File(folderPath);
                if(!newFile.isDirectory()){
                    newFile.mkdirs();
                }

                String fileName = file.getOriginalFilename();
                Date date = new Date();
                DateFormat format = new SimpleDateFormat("yyyyMMdd");
                String time = format.format(date);
                int index = fileName.lastIndexOf(".");
                String subString = fileName.substring(0, index);
                String newFileName = subString + "_" + time + fileName.substring(index);

                String filePath = folderPath + newFileName;
                file.transferTo(new File(filePath));
                return filePath;
            } catch (Exception e) {
                return "";
            }
        } else {
            return "";
        }
    }
}
