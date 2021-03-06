# Generated by Django 3.0 on 2020-09-05 04:38

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('usuario', '0002_auto_20200905_0131'),
    ]

    operations = [
        migrations.CreateModel(
            name='Docente',
            fields=[
                ('division', models.CharField(max_length=1)),
                ('nombre', models.CharField(max_length=60)),
                ('apellido', models.CharField(max_length=60)),
                ('dni', models.IntegerField(primary_key=True, serialize=False)),
                ('fechaNacimiento', models.DateField()),
                ('telefono', models.IntegerField()),
                ('email', models.EmailField(max_length=254, unique=True)),
                ('horasCatedra', models.IntegerField()),
            ],
        ),
        migrations.AlterField(
            model_name='alumno',
            name='apellido',
            field=models.CharField(max_length=60),
        ),
        migrations.AlterField(
            model_name='alumno',
            name='año',
            field=models.IntegerField(),
        ),
        migrations.AlterField(
            model_name='alumno',
            name='telefono',
            field=models.IntegerField(),
        ),
    ]
