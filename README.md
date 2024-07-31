# 测试案例
https://github.com/yangbuyiya/test-yby6-openai-review

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

# 新增workflows 代码审核 main-remote-jar.yml

> 评审代码的分钟默认为 `master` 分支
> 如需更改分支，修改 `push` branches，`pull_request` branches 即可

```yaml

name: Build and Run OpenAiCodeReview By Main Maven Jar

on:
  push:
    branches:
      - master
  pull_request:
    branches:
      - master

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v2
        with:
          fetch-depth: 2

      - name: Set up JDK 11
        uses: actions/setup-java@v2
        with:
          distribution: 'adopt'
          java-version: '11'

      - name: Create libs directory
        run: mkdir -p ./libs

      # 使用 wget 下载 openai-code-review-sdk JAR 进行构建评审代码
      - name: Download openai-code-review-sdk JAR
        run: wget -O ./libs/yby6-openai-code-review-sdk-1.0.jar https://github.com/yangbuyiya/yby6-openai-code-review-log/releases/download/v1.0/yby6-openai-code-review-sdk.jar

      - name: Get repository name
        id: repo-name
        run: echo "REPO_NAME=${GITHUB_REPOSITORY##*/}" >> $GITHUB_ENV

      - name: Get branch name
        id: branch-name
        run: echo "BRANCH_NAME=${GITHUB_REF#refs/heads/}" >> $GITHUB_ENV

      - name: Get commit author
        id: commit-author
        run: echo "COMMIT_AUTHOR=$(git log -1 --pretty=format:'%an <%ae>')" >> $GITHUB_ENV

      - name: Get commit message
        id: commit-message
        run: echo "COMMIT_MESSAGE=$(git log -1 --pretty=format:'%s')" >> $GITHUB_ENV

      - name: Print repository, branch name, commit author, and commit message
        run: |
          echo "Repository name is ${{ env.REPO_NAME }}"
          echo "Branch name is ${{ env.BRANCH_NAME }}"
          echo "Commit author is ${{ env.COMMIT_AUTHOR }}"
          echo "Commit message is ${{ env.COMMIT_MESSAGE }}"      

      # 执行代码审查 MANIFEST.MF 会执行指定的Class
      - name: Run Code Review
        run: java -jar ./libs/yby6-openai-code-review-sdk-1.0.jar
        # 环境变量 配置
        env:
          # Github 配置；GITHUB_REVIEW_LOG_URI「https://github.com/yangbuyiya/yby6-openai-code-review-log」、GITHUB_TOKEN「https://github.com/settings/tokens」
          GITHUB_REVIEW_LOG_URI: ${{ secrets.CODE_REVIEW_LOG_URI }}
          GITHUB_TOKEN: ${{ secrets.CODE_TOKEN }}
          COMMIT_PROJECT: ${{ env.REPO_NAME }}
          COMMIT_BRANCH: ${{ env.BRANCH_NAME }}
          COMMIT_AUTHOR: ${{ env.COMMIT_AUTHOR }}
          COMMIT_MESSAGE: ${{ env.COMMIT_MESSAGE }}
          # 微信配置 「https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index」
          WEIXIN_APPID: ${{ secrets.WEIXIN_APPID }}
          WEIXIN_SECRET: ${{ secrets.WEIXIN_SECRET }}
          WEIXIN_TOUSER: ${{ secrets.WEIXIN_TOUSER }}
          WEIXIN_TEMPLATE_ID: ${{ secrets.WEIXIN_TEMPLATE_ID }}
          # OpenAi - ChatGLM 配置「https://open.bigmodel.cn/api/paas/v4/chat/completions」、「https://open.bigmodel.cn/usercenter/apikeys」
          CHAT_API: ${{ secrets.CHAT_API }}
          CHAT_APPKEY: ${{ secrets.CHAT_APPKEY }}


```
