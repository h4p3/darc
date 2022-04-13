drop table if exists `${name}`;
CREATE TABLE `${name}` (
`id` bigint NOT NULL AUTO_INCREMENT,
`code` varchar(50) NOT NULL,
<#list fields as field>
    `${field.name}` ${field.type}<#if field.length != 0>(${field.length} <#if field.decimal !=0>,${field.decimal} </#if>)</#if> <#if field.notnull==true>not null</#if> <#if field.creative==true>AUTO_INCREMENT</#if> <#if field.defaultValue?? && field.defaultValue!=''>default ${field.defaultValue}</#if> <#if field.desc!='' && field.desc?? >COMMENT "${field.desc}"</#if>,
</#list>
`deleted` tinyint NOT NULL DEFAULT '0',
`create_by` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
`update_by` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
`create_time` bigint NOT NULL,
`update_time` bigint NOT NULL,
PRIMARY KEY (`id`) USING BTREE,
UNIQUE KEY udx_code(`code`) USING BTREE
) ENGINE=${engine} AUTO_INCREMENT=1 DEFAULT CHARSET=${charset} COLLATE=${sort} COMMENT="${desc}";


ALTER TABLE `${name}`
<#list indexes as index>
    ADD ${index.type} <#if index.type !='INDEX'>INDEX</#if> `${index.name}`( ${index.fields?join(",")} ) USING ${index.method} COMMENT "${index.desc}" <#sep>,
</#list>
;