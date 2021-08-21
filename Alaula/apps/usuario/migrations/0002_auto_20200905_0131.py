# Generated by Django 3.0 on 2020-09-05 04:31

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('usuario', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Aula',
            fields=[
                ('id', models.IntegerField(primary_key=True, serialize=False)),
                ('cantidadAlumnos', models.IntegerField()),
            ],
        ),
        migrations.AlterField(
            model_name='alumno',
            name='dni',
            field=models.IntegerField(primary_key=True, serialize=False),
        ),
        migrations.AddField(
            model_name='alumno',
            name='idAula',
            field=models.ForeignKey(default=0, on_delete=django.db.models.deletion.DO_NOTHING, to='usuario.Aula'),
            preserve_default=False,
        ),
    ]
