# codeing=gbk
from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField, TextAreaField, SelectField, FloatField
from wtforms.validators import DataRequired, Length


class NameForm(FlaskForm):
    name = StringField('你的名字是', validators=[DataRequired(), Length(1, 64)])
    submit = SubmitField('提交')


class PostForm(FlaskForm):
    body = TextAreaField('作业内容', validators=[DataRequired()])

    tag = SelectField(
        label='选择班级',
        validators=[DataRequired('请选择班级')],
        choices=[],
        coerce=int
    )
    submit = SubmitField('发布')


class ThresholdForm(FlaskForm):
    threshold = FloatField('设定查重阈值', validators=[DataRequired()])
    submit = SubmitField('设定')


class FileForm(FlaskForm):
    file1name = StringField('输入文件1名称', validators=[DataRequired(), Length(1, 64)])
    file2name =StringField('输入文件2名称', validators=[DataRequired(), Length(1, 64)])
    submit = SubmitField('确定')
