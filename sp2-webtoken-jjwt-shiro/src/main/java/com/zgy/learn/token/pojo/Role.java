package com.zgy.learn.token.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Role实体类
 *
 * @author z.g.y
 * @since 2021-02-01 00:56:51
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Role implements Serializable {
    private static final long serialVersionUID = -14076222853162143L;
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 显示名称
     */
    private String displayName;
    /**
     * 建立时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}