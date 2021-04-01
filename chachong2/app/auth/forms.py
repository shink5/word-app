#codeing=gbk
from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, BooleanField, SubmitField
from wtforms.validators import DataRequired, Length, NumberRange, Regexp, EqualTo
from wtforms import ValidationError
from ..models import User


class LoginForm(FlaskForm):
    user_id = StringField('学号', validators=[DataRequired(), Length(1, 64), NumberRange()], render_kw={'placeholder': u'请输入学号','required':True})
    password = PasswordField('密码', validators=[DataRequired()],render_kw={'placeholder': u'请输入密码'})
    remember_me = BooleanField('记住密码')
    submit = SubmitField('登录')


class RegistrationForm(FlaskForm):
    user_id = StringField('学号', validators=[DataRequired(), Length(1, 64),NumberRange()],render_kw={'placeholder': u'请输入学号'})
    username = StringField('姓名', validators=[
        DataRequired(), Length(1, 64),
        Regexp('^[\u4e00-\u9fa5]*$', 0,
               '名字必须是中文')],render_kw={'placeholder': u'请输入姓名'})
    password = PasswordField('密码', validators=[
        DataRequired(), EqualTo('password2', message='密码必须一致')],render_kw={'placeholder': u'请输入密码'})
    password2 = PasswordField('确认密码', validators=[DataRequired()],render_kw={'placeholder': u'请再次输入密码'})
    submit = SubmitField('注册')

    def validate_user_id(self, field):
        if User.query.filter_by(user_id=int(field.data)).first():
            raise ValidationError('学号已使用')


class ChangePasswordForm(FlaskForm):
    old_password = PasswordField('旧密码', validators=[DataRequired()],render_kw={'placeholder': u'请输入旧密码'})
    password = PasswordField('新密码', validators=[
        DataRequired(), EqualTo('password2', message='密码不一致')],render_kw={'placeholder': u'请输入新密码'})
    password2 = PasswordField('确认密码',
                              validators=[DataRequired()],render_kw={'placeholder': u'请再次输入新密码'})
    submit = SubmitField('更改密码')




class PasswordResetForm(FlaskForm):
   password = PasswordField('新密码', validators=[DataRequired(), EqualTo('password2', message='密码不一致')])
   password2 = PasswordField('确认密码', validators=[DataRequired()])
   submit = SubmitField('密码重置')


