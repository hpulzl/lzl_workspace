#前言
在使用linux系统进行服务部署时候，难免会用到常用的linux指令。但是有时候，有些指令不知道如何使用，最近也是在玩部署的时候发现自己对linux指令的不了解，但是最后通过查资料也学到了不少的linux常用指令。在这里做一个汇总吧，难免以后会再用到。

#ssh登录

语法说明(p为小写)

ssh -p 端口 用户名@IP

```
ssh -p 5188 support@127.0.0.1
```
# scp上传下载
此处的IP是随便写的

文件上传语法说明(P为大写)

scp -P 端口 本地环境路径 用户名@IP:服务器路径

```
scp -P 5188 /Users/vobile_lzl/vobile/wasu_hss/target/HSS-0.0.1-SNAPSHOT.jar support@127.0.0.1:/home/support/hss
```
文件下载语法说明(P为大写)

scp -P 端口 用户名@IP:服务器路径 本地环境路径

```
scp -P 5188 support@127.0.0.1:/home/support/hss/logs/all.log /Users/vobile_lzl/vobile/
```

#cp和mv

* 复制一个目录下的所有文件到指定目录

```
cp -rf dist/*  /etc/nginx/html/dist/
/etc/nginx/html/dist
```
* 复制一个文件到指定文件夹

```
cp hss安装.doc  mybatis-pagehelper-mapper/
```

* 移动一个文件夹到指定文件夹中

```
mv src/ mybatis-pagehelper-mapper/
```
* 移动一个文件到指定文件夹中

```
mv java.zip mybatis-pagehelper-mapper/
```

#vim和vi

关于vi和vim的指令介绍有很多，我们可以参看优秀的总结
http://www.runoob.com/linux/linux-vim.html

这里我总结一下我常用的指令

> vim编辑分为三种模式:

> * 命令模式 (按`esc`键切换)
> * 插入模式 (输入`i`字符)
> * 底线命令模式 (按`esc`+`:`进入)

```
vim my.txt
i 编辑文件
d 删除光标所在行字符

esc + :q! 不保存退出
esc + :wq! 保存编辑退出
gg:命令将光标移动到文档开头
G:命令将光标移动到文档末尾
```
#测试端口和服务连接
ping telnet curl

* 测试IP

ping IP

```
ping 127.0.0.1

```
* 测试端口

telnet IP/域名 端口

```
telnet www.baidu.com 80
```
使用`ctrl+]`键进入`telnet`模式，`quit`退出telnet



* 测试http请求

curl http路径

```
curl http://www.baidu.com
```
