# -*- encoding=UTF-8 -*-

import os
import os.path as op
import numpy as np
import pandas as pd
import io
import re

key = []
str = []


def sim_total(*file_path):  # 输入两个文件或一个文件夹，若为文件夹返回（文件相似度矩阵，自适应阈值），若为两个文件，返回相似度
    if len(file_path) == 1:
        threshold = 0
        sim_value=0
        max = 0
        min = 100
        files = os.listdir(file_path[0])  # 得到文件夹下的所有文件名称
        for file in files:
            if not os.path.isfile(file_path[0] + "\\" + file):
                files.remove(file)
        matrix = pd.DataFrame([], index=files, columns=files)
        if not os.path.exists(file_path[0] + "\\pre"):
            os.makedirs(file_path[0] + "\\pre")
        for file1 in files:
            if not os.path.isdir(file_path[0] + "\\" + file1):
                path1 = file_path[0] + "\\" + file1
            for file2 in files:
                if not os.path.isdir(file_path[0] + "\\" + file2):
                    if file1 != file2:
                        path2 = file_path[0] + "\\" + file2
                        pre_path1 = file_path[0] + "\\pre\\pre_" + file1
                        pre_path2 = file_path[0] + "\\pre\\pre_" + file2
                        sim_value = round(sim(path1, pre_path1, path2, pre_path2),3)
                        threshold = threshold+ sim_value
                        if max < sim_value:
                            max = sim_value
                        if min > sim_value:
                            min = sim_value
                        matrix[file1][file2] = sim_value
                        matrix[file2][file1] = sim_value
        if len(files) > 2:
            threshold = ((threshold/2)- max - min) / (len(files)*(len(files)-1)/2-2)
        else:
            threshold = 1
        return (matrix, round(threshold,3))

    if len(file_path) == 2:
        path1 = file_path[0]
        path2 = file_path[1]
        pre_path1 = os.path.dirname(file_path[0]) + r"\pre_" + os.path.basename(file_path[0])
        pre_path2 = os.path.dirname(file_path[1]) + r"\pre_" + os.path.basename(file_path[1])
        return sim(path1, pre_path1, path2, pre_path2)


def get_variable(path):  # 返回txt文件中包含所有自定义变量名的列表
    mark = 0
    mark_typedef = 0

    key=['char','double','enum','float','int','long','short']

    with open(path, 'r', encoding='gbk') as file:
        for line in file.readlines():
            if not line or 'while(' in line.replace(' ', ''):  # 含while则跳过
                continue
            elif re.search(r'//.*', line) and mark == 0:  # 去除//型注释
                line = re.sub(r'//.*$', '', line)
            elif re.search(r'/\*.*[^\*/]', line) and mark == 0:  # 遇到/*
                mark = 1
                line = re.sub(r'/\*.*[^\*/]', '', line)
                if re.search(r'\*/', line):  # 若/* */注释在同一行结束
                    mark = 0
                    line = re.sub(r'\*/', '', line)
            elif mark == 1:  # 若该行还处于/*  */型注释文段内
                if re.search(r'\*/', line):  # 若/* */型注释在该行结束
                    mark = 0
                    continue
                else:
                    continue
            if mark_typedef == 1:  # 用typedef命名了struct或union类型
                if '}' not in line:
                    pass
                else:
                    mark_typedef = 0;
                    iter = re.findall('}?\s*\**\s*(\S*?)(\[.*?])?[,;]', line)
                    for i in iter:
                        key.append(i[0])
                    continue
            elif mark == 1:  # 定义struct或union但没有typedef
                if '}' not in line:
                    pass
                else:
                    mark = 0
                    iter = re.findall('}?\s*\**\s*(\S*?)(\[.*?])?[,;]', line)
                    for i in iter:
                        if i[0] != '':
                            str.append(i[0])  # 直接加入变量名列表中
                    continue
            elif '#define' in line:  # 将define的改动增加到数据类型名称中
                if re.search('#define\s+(\S*)\s+(\S*)', line) != None and re.search('#define\s+(\S*)\s+(\S*)',
                                                                                    line).group(1) in key:
                    key.append(re.search('#define\s+(\S*)\s+(\S*)', line).group(2))
            elif 'typedef' in line and 'struct' not in line and 'union' not in line:  # 将typedef的改动增加到数据类型名称中
                key.append(re.search('typedef\s+\S*\s+(\S*)', line).group(1))
            elif ('struct' in line or 'union' in line) and ';' not in line:  # struct或union定义
                if 'typedef' in line:
                    mark_typedef = 1
                else:
                    mark = 1
                if re.search('struct\s+\S+', line) != None:
                    key.append(re.search('struct\s+\S+', line).group())
                if re.search('union\s+\S+', line) != None:
                    key.append(re.search('union\s+\S+', line).group())
            if 'for(' in line.replace(' ', ''):  # for循环只选取第一个分号前的内容
                if re.search('\((.*?;).*?\)', line) != None:
                    line = re.search('\((.*?;).*?\)', line).group(1).replace(' ', '')
            if line.replace(' ', '').strip().endswith((')', '{')) and 'for(' not in line:  # 函数定义
                if re.search('\((.*?)\)', line) != None:
                    line = re.search('\((.*?)\)', line).group(1).replace(' ', '')
                    line_split = line.replace(';', ',').split(',')
                    for i in line_split:
                        for k in key:
                            if re.search(k + '\**(.*?)', i) != None:
                                str.append(re.search(k + '\**(.*)', i).group(1))
                                break
                else:
                    pass
            else:  # 普通语句
                for k in key:
                    if line.lstrip().startswith(k):
                        if re.search('\{.*?\}', line) != None:
                            line = line.replace(re.search('\{.*?\}', line).group(), '')
                        if re.search(k + '(.*?);', line):
                            line = re.search(k + '(.*?);', line).group(1)
                        line_split = line.replace('*', '').split(',')
                        for slice in line_split:
                            slice = slice.replace(' ', '')
                            if '=' in slice:
                                str.append(re.search('(.*)?=', slice).group(1))
                            elif '[' in slice:
                                str.append(re.search('(.*)?\[', slice).group(1))
                            else:
                                str.append(slice)
    return str


def pretreatment(path, pre_path):
    mark = 0  # 针对/*   */注释的标记
    file2 = io.open(pre_path, 'w', encoding='utf-8')

    with open(path, 'r', encoding='gbk') as file1:
        str = get_variable(path)
        for line in file1.readlines():
            # 替换变量名为var

            if not line:
                continue
            elif re.search(r'//.*', line) and mark == 0:  # 去除//型注释
                line = re.sub(r'//.*$', '', line)
            elif re.search(r'/\*.*[^\*/]', line) and mark == 0:  # 遇到/*
                mark = 1
                line = re.sub(r'/\*.*[^\*/]', '', line)
                if re.search(r'\*/', line):  # 若/* */注释在同一行结束
                    mark = 0
                    line = re.sub(r'\*/', '', line)
            elif mark == 1:  # 若该行还处于/*  */型注释文段内
                if re.search(r'\*/', line):  # 若/* */型注释在该行结束
                    mark = 0
                    continue
                else:
                    continue
            for k in str:
                if k in line:
                    if re.search(r'[^0-9A-Z_a-z]' + k + '[^0-9A-Z_a-z]', line):
                        line = re.sub(r'([^\w])' + k + '([^\w])', '\g<1>var\g<2>', line)
            line = line.replace('/t', '').replace(' ', '')  # 去除制表符和空格
            if line == '\n':  # 若取消该判断则变为行数与原文件相同
                continue
            file2.write(line)
    file2.close()


def lcs(list1, list2):
    size1 = len(list1)
    size2 = len(list2)

    c = [[0 for i in range(size2 + 1)] for j in range(size1 + 1)]

    for i in range(size1):
        for j in range(size2):
            if list1[i] == list2[j]:
                c[i + 1][j + 1] = c[i][j] + 1
            elif c[i + 1][j] > c[i][j + 1]:
                c[i + 1][j + 1] = c[i + 1][j]
            else:
                c[i + 1][j + 1] = c[i][j + 1]

    if c[size1][size2] >= 0:
        return c[size1][size2]
    else:
        print('LCS函数报错')
        return


def sim(path1, pre_path1, path2, pre_path2):
    pretreatment(path1, pre_path1)
    pretreatment(path2, pre_path2)

    file1 = io.open(pre_path1, 'r', encoding='utf-8')
    file2 = io.open(pre_path2, 'r', encoding='utf-8')
    list1 = []
    list2 = []

    for line in file1.readlines():
        line = line.strip()
        # print(line)
        list1.append(line)

    for line in file2.readlines():
        line = line.strip()
        # print(line)
        list2.append(line)

    length = lcs(list1, list2)  # flag存储对应的重复代码在pre文件中的位置

    try:
        similarity = (2 * length) / (len(list1) + len(list2))
    except similarity > 1 or similarity < 0:
        print('Sim函数出现问题，报错')
    else:
        return similarity
