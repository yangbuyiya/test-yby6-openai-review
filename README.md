
# 申请 GitHub Token
地址：https://github.com/settings/tokens
创建后，保存生成的 Token，用于配置到 GitHub Actions 参数中

![](https://cdn.nlark.com/yuque/0/2024/png/2426233/1722393150863-5856a60d-1a12-4612-8c0a-39384e0ef92d.png?x-oss-process=image%2Fformat%2Cwebp)
![](https://cdn.nlark.com/yuque/0/2024/png/2426233/1722394143278-2d0f49f4-1500-4cd5-98ba-280f6dbc0825.png?x-oss-process=image%2Fformat%2Cwebp)

# 申请微信公众号Token
地址：https://mp.weixin.qq.com/
测试号：https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index

> 这个测试公众号等同于企业公众号，有对应的模板消息。
申请后，你就会获得 appID、appsecret、tourse - 就是谁关注了公众号，就会展示一个分配的微信号，推送模板消息就是给这个用户推送。
模板消息，自己新建一个。之后就获得ID。消息格式如下；
```java
项目：{{repo_name.DATA}} 分支：{{branch_name.DATA}} 作者：{{commit_author.DATA}} 说明：{{commit_message.DATA}}
```



# GitHub Actions 配置

| Key                 | Value                                                                          |
|---------------------|--------------------------------------------------------------------------------|
| CHAT_API            | https://open.bigmodel.cn/api/paas/v4/chat/completions                          |
| CHAT_APPKEY         | 大模型 apiKey                                                                     |
| CODE_REVIEW_LOG_URI | [https://github.com/yangbuyiya/yby6-openai-code-review-log](你需要记录到的仓库不带.git后缀) |
| CODE_TOKEN          | `Github Token 对仓库进行提交日志操作`                                                     |
| WEIXIN_APPID        | `微信公众号APPID`                                                                   |
| WEIXIN_SECRET       | `微信公众号密钥`                                                                      |
| WEIXIN_TEMPLATE_ID  | `微信公众号模板ID`                                                                    |
| WEIXIN_TOUSER       | `OPENID 微信公众号关注后推送的人`                                                          |

