# 基于优先级的非抢占/抢占进程调度算法模拟程序

### 作者：vili &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 联系方式：1976763043@qq.com

*2018年操作系统的大作业,程序使用java语言在IDEA上编写,因为涉及图形界面,故需要安装jframe插件.*
## 目录

* [1.程序功能](#1)
* [2.程序截图](#2)

<h2 id="1">1.程序功能</h2>

1.提供三种动态分区模拟算法：首次适应算法，最佳适应算法，最坏适应算法。

2.利用画布动态显示内存分区当前情况（灰色为空闲，红色为已分配）。

3.显示空闲分区链及已分配的内存块情况。

4.内存初始容量自行设定，使用前请初始化内存。

5.分配算法可以自由选择，在运行期间也可以更换算法（但空闲分区链并不会按算法显示）。

6.用户可随时添加新进程，输入进程名和长度后程序按照当前的分配算法进行分配，内存默认分配空闲内存块的高地址部分。

7.当申请内存容量大于任意一块空闲内存的大小时，将实行紧凑算法，程序将从后向前搜索空闲分区并计数，当空闲空间块的总容量大于进程需求容量时，算法停止搜索，将搜索最后一个空闲分区块之前的所有已分配的内存块向前移动，将几个空闲分区块合并并放在高地址部分，然后执行正常分配算法，将当前合并的空闲分区块按高地址部分分出。

8.如果当前紧凑算法结束，合并后的空闲分区块仍无法满足申请内存的需求，则会提示”内存不足，无法分配。“

9.用户可随时将申请的内存块释放，输入进程名称并点击返还即可释放内存。

10.当进程名称不存在时，系统将给出错误提示。

<h2 id="2">2.程序截图</h2>

主界面：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/MemoryAllocation/主界面.png)

申请内存：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/MemoryAllocation/申请内存.png)

紧凑：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/MemoryAllocation/紧凑.png)

申请内存失败：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/MemoryAllocation/申请内存失败.png)

释放内存：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/MemoryAllocation/释放内存.png)

释放内存失败：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/MemoryAllocation/释放内存失败.png)
