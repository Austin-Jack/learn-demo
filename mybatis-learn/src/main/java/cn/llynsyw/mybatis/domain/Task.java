package cn.llynsyw.mybatis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * TODO
 *
 * @author luolinyuan
 * @since 2023/9/1
 **/
@Data
@Entity
@AllArgsConstructor
@Table(name = "test")
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean completed;
}
