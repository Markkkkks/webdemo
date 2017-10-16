# 思路

- 通过`System.currenttime`+随机数生成伪随机数
- 进行md5散列后对其进行base64编码生成token
- 对token进行表单隐藏和session设置，形成client端与Server端token
- 在doform的servlet进行核对，如果核对相同，删除session中的token