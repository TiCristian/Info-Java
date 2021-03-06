# Generated by Django 3.0 on 2020-09-14 21:36

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('usuario', '0004_institucion_materia'),
    ]

    operations = [
        migrations.CreateModel(
            name='Anio',
            fields=[
                ('id_anio', models.IntegerField(primary_key=True, serialize=False)),
            ],
        ),
        migrations.CreateModel(
            name='Usuario',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('username', models.CharField(max_length=40, unique=True)),
                ('password', models.CharField(max_length=80)),
                ('email', models.EmailField(max_length=100)),
                ('first_name', models.CharField(max_length=60)),
                ('last_name', models.CharField(max_length=60)),
            ],
        ),
        migrations.RemoveField(
            model_name='alumno',
            name='idAula',
        ),
        migrations.DeleteModel(
            name='Docente',
        ),
        migrations.DeleteModel(
            name='Alumno',
        ),
    ]
