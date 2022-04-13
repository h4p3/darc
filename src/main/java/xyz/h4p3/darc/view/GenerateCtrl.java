package xyz.h4p3.darc.view;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.h4p3.darc.model.TableModel;

/**
 *
 * 127.0.0.1:13823/gen
 *
 * @author neal.armstrong
 * @version 1.0
 * @since 2022-04-13
 */
@RestController
@RequestMapping(value = "/")
@AllArgsConstructor
public class GenerateCtrl {

    /*

    {
    "name": "bop_just_test",
    "desc": "测试表生成",
    "engine": "INNODB",
    "charset": "utf8mb4",
    "sort": "utf8mb4_general_ci",
    "fields": [
        {
            "name": "payment_region",
            "type": "varchar",
            "unSign": false,
            "creative": false,
            "length": 50,
            "decimal": 0,
            "notnull": true,
            "desc": "付款区域",
            "defaultValue": ""
        },
        {
            "name": "bo_share_rate",
            "type": "decimal",
            "unSign": false,
            "creative": false,
            "length": 24,
            "decimal": 4,
            "notnull": true,
            "desc": "渠道方给BO技术方分成比例",
            "defaultValue": ""
        },
        {
            "name": "channel_id",
            "type": "bigint",
            "unSign": false,
            "creative": false,
            "length": 0,
            "decimal": 0,
            "notnull": true,
            "desc": "关联上游渠道信息表bop_upstream_channel_info表的id",
            "defaultValue": ""
        }
    ],
    "indexes": [
        {
            "name": "udx_channelId",
            "fields": [
                "channel_id"
            ],
            "type": "UNIQUE",
            "method": "btree",
            "desc": "主键索引"
        }
    ]
}
     */

    @PostMapping(value = "gen")
    public String generate(@RequestBody TableModel tableModel) {
        tableModel.generate();
        return "ok";
    }
}
