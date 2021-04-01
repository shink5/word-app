#codeing=utf-8

from datetime import datetime
import hashlib
from werkzeug.security import generate_password_hash, check_password_hash
from flask import current_app
from flask_login import UserMixin
from . import db, login_manager


registrations = db.Table('registrations',
    db.Column('user_id', db.Integer, db.ForeignKey('users.id')),
    db.Column('class_id', db.Integer, db.ForeignKey('classes.id'))
)

class User(UserMixin, db.Model):
    __tablename__ = 'users'
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(64), unique=True, index=True)
    is_teacher = db.Column(db.Boolean, default=False)
    password=db.Column(db.String(128))
    #password_hash = db.Column(db.String(128))
    confirmed = db.Column(db.Boolean, default=False)
    classes = db.relationship('Class', secondary = registrations,
        back_populates='users', lazy='dynamic')
    posts = db.relationship('Post', backref='author', lazy='dynamic')
#导入学校数据库...

#暂定设置密码
    """@property
    def password(self):
        raise AttributeError('password is not a readable attribute')

    @password.setter
    def password(self, password):
        self.password_hash = generate_password_hash(password)

    def verify_password(self, password):
        return check_password_hash(self.password_hash, password)


    @staticmethod
    def reset_password(id,new_password):
        user = User.query.get(int(id))
        if user is None:
            return False
        user.password = new_password
        db.session.add(user)
        return True"""
    def verify_password(self, password):
        if self.password == password:
            return True
        else:
            return False
    def get_id(self):
        return str(self.id)
    def __repr__(self):
        return '<User %r>' % self.username

class Class(db.Model):
    __tablename__ = 'classes'
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(64), unique=True)
    users = db.relationship('User', secondary = registrations,
        back_populates='classes', lazy='dynamic')
    posts=db.relationship('Post', backref='cls', lazy='dynamic')
@login_manager.user_loader
def load_user(id):
    return User.query.get(int(id))

class Post(db.Model):
    __tablename__ = 'posts'
    id = db.Column(db.Integer, primary_key=True)
    body = db.Column(db.Text)
    timestamp = db.Column(db.DateTime, index=True, default=datetime.utcnow)
    author_id = db.Column(db.Integer, db.ForeignKey('users.id'))
    class_id = db.Column(db.Integer, db.ForeignKey('classes.id'))
    
