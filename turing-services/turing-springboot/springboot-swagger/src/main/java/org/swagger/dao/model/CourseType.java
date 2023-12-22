package org.swagger.dao.model;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @descri: 
 *
 * @author: lj.michale
 * @date: 2023/12/22 10:47
 */
@Getter
@AllArgsConstructor
public enum CourseType {
    /**
     * 图文
     */
    PICTURE(102, "图文"),
    /**
     * 音频
     */
    AUDIO(103, "音频"),
    /**
     * 视频
     */
    VIDEO(104, "视频"),
    /**
     * 外链
     */
    URL(105, "外链");

    private final int type;
    private final String desc;

    @Override
    public String toString() {
        return this.type+":"+this.desc;
    }
}