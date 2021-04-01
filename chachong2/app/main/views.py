from flask import render_template, redirect, url_for, abort, flash, request, \
    current_app, make_response, send_file, send_from_directory, session
from flask_login import login_required, current_user
from . import main
from .. import db
from .forms import PostForm, ThresholdForm, FileForm
from ..models import User, Post, Class
from ..decorators import teacher_required
from werkzeug.utils import secure_filename
from .zip_file import zip_file
import os
import chardet
from . LCS_Sim import sim_total
import sys
sys.path.append('/mnt/d/chachong')
from config import Config
import pandas as pd
import numpy as np


@main.route('/')
def index():
    if current_user.is_authenticated:
        return redirect(url_for('.work'))
    return render_template('index.html')



@login_required
@main.route('/work', methods=['GET', 'POST'])
def work():
    choices=[]
    for cls in User.query.get_or_404(current_user.id).classes.all():
        choices.append((cls.id, cls.name))
    form = PostForm()
    form.tag.choices=choices
    print(form.tag.choices)
    if current_user.is_teacher and form.validate_on_submit():
        print(form.tag.data)
        post = Post(body=form.body.data, author=current_user._get_current_object(), cls=Class.query.get_or_404(form.tag.data))
        db.session.add(post)
        db.session.commit()
        return redirect(url_for('.work'))
    page = request.args.get('page', 1, type=int)
    pagination = Post.query.order_by(Post.timestamp.desc()).paginate(
        page, per_page=current_app.config['FLASKY_POSTS_PER_PAGE'],
        error_out=False)
    posts = pagination.items
    return render_template('work.html', form=form, posts=posts, Class=Class,
                           pagination=pagination)

@login_required
@main.route('/user/<int:id>')
def user(id):
    user = User.query.filter_by(id=id).first_or_404()
    page = request.args.get('page', 1, type=int)
    pagination = user.posts.order_by(Post.timestamp.desc()).paginate(
        page, per_page=current_app.config['FLASKY_POSTS_PER_PAGE'],
        error_out=False)
    posts = pagination.items
    return render_template('user.html', user=user, posts=posts,
                           pagination=pagination)

@login_required
@teacher_required
@main.route('/chachong/<int:id>', methods=['POST', 'GET'])
def chachong(id):
    flag = 0
    threshold_form = ThresholdForm()
    path = os.path.join(Config.BASEPATH, str(id))
    path = os.path.abspath(path)

    data = sim_total(path)
    results = data[0]
    indexs = results.index

    file_form = FileForm()

    xu=pd.Series(index=indexs,dtype=int)
    i=0
    for index in indexs:
        xu[index] = i
        i=i+1

    list1 = []
    list2 = []
    files = []

    threshold = 0.8
    # if session.get('threshold') is not None:
    #     threshold = session.get('threshold')

    file1name = ' '
    file2name = ' '
    # if session.get('file1name') is not None and session.get('file2name') is not None:
    #     file1name = session.get('file1name')
    #     file2name = session.get('file2name')



    for index in indexs:
        for index1 in indexs:
            if results[index][index1]>=threshold:
                list1.append(index1)
                list1.append(index)

                list2.append(index1)
        files.append(list(set(list2)))
        list2.clear()
    list3=list(set(list1))

    result_for_two_files = 0.0

    if threshold_form.validate_on_submit():
        threshold = threshold_form.threshold.data
        list1 = []
        list2 = []
        files = []
        for index in indexs:
            for index1 in indexs:
                if results[index][index1] >= threshold:
                    list1.append(index1)
                    list1.append(index)

                    list2.append(index1)
            files.append(list(set(list2)))
            list2.clear()
        list3 = list(set(list1))
        return render_template('chachong.html', results=results, result_for_two_files=result_for_two_files,
                               yu=threshold_form.threshold.data,
                               indexs=results.index, list=list3, files=files, file1name=file1name, file2name=file2name,
                               xu=xu, threshold_form=threshold_form, file_form=file_form, flag = flag)
    if file_form.validate_on_submit():
        file1name = file_form.file1name.data
        file2name = file_form.file2name.data
        path1 = os.path.join(path, file1name)
        path2 = os.path.join(path, file2name)

        flag = 1

        if file1name in indexs and file2name in indexs:
            flag = 2
            result_for_two_files = sim_total(path1, path2)
        return render_template('chachong.html', results=results, result_for_two_files=result_for_two_files,
                               yu=threshold,
                               indexs=results.index, list=list3, files=files, file1name=file1name, file2name=file2name,
                               xu=xu, threshold_form=threshold_form, file_form=file_form, flag=flag)

    return render_template('chachong.html', results=results, result_for_two_files=result_for_two_files, yu=threshold,
                           indexs=results.index, list=list3, files=files, file1name=file1name, file2name=file2name,
                           xu=xu, threshold_form=threshold_form, file_form=file_form, flag=flag)

# @login_required
# @teacher_required
# @main.route('/chachong2/<int:id>/<file1name>/<file2name>')
# # def chachong2(id):
# #     path = os.path.join(Config.BASEPATH, str(id))
# #     path = os.path.abspath(path)
# #     path1 = os.path.join(path, file1name)
# #     path2 = os.path.join(path, file2name)
# #     result = sim_total(path1, path2)
# #     return  render_template('chachong2.html',result = result)

@login_required
@main.route('/upload/<int:id>/<filename>', methods=['POST', 'GET'])
def upload(id, filename):
    if request.method == 'POST':
        f = request.files['file']
        basepath = os.path.dirname(__file__)  # ��ǰ�ļ�����·��
        basepath = os.path.join(basepath, 'upload_file_dir')
        upload_path = os.path.join(basepath, str(id))
        if not os.path.exists(upload_path):
            os.mkdir(upload_path)
        upload_path = os.path.join(basepath, str(id), filename)
        # ע�⣺û�е��ļ���һ��Ҫ�ȴ�������Ȼ����ʾû�и�·��
        upload_path = os.path.abspath(upload_path) # ��·��ת��Ϊ����·��
        f.save(upload_path)
        return redirect(url_for('main.upload', id=id, filename = filename))
    return render_template('upload.html')

@login_required
@teacher_required
@main.route('/post/<int:id>')
def post(id):
    post = Post.query.get_or_404(id)
    path = os.path.join(Config.BASEPATH, str(id))
    path = os.path.abspath(path)
    if not os.path.exists(path):
        os.mkdir(path)
    count = len(os.listdir(path))
    student_count=0
    for user in post.cls.users.all():
        if(user.is_teacher == False):
            student_count+=1
    filelist = os.listdir(path)
    return render_template('post.html',post=post, count=count,
        filelist=filelist, student_count=student_count)

@login_required
@teacher_required
@main.route('/download/<int:id>/<filename>')
def download(id,filename):
    path = os.path.join(Config.BASEPATH, str(id),filename)
    path = os.path.abspath(path)
    response = make_response(send_file(path,mimetype='text/csv',attachment_filename='Adjacency.csv'))
    return response

@login_required
@teacher_required
@main.route('/downloads/<int:id>')
def downloads(id):
    path = os.path.join(Config.BASEPATH, str(id))
    path = os.path.abspath(path)
    path_zip=path+'.zip'
    zip_file(path)
    response = make_response(send_file(path_zip,mimetype='application/zip'))
    return response
