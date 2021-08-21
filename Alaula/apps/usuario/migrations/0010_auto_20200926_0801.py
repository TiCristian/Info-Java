# Generated by Django 3.0 on 2020-09-26 11:01

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('institucion', '0003_materia_id_anio'),
        ('usuario', '0009_auto_20200923_2000'),
    ]

    operations = [
        migrations.RenameField(
            model_name='usuario',
            old_name='first_name',
            new_name='apellido',
        ),
        migrations.RenameField(
            model_name='usuario',
            old_name='last_name',
            new_name='nombre',
        ),
        migrations.RemoveField(
            model_name='usuario',
            name='es_profesor',
        ),
        migrations.CreateModel(
            name='Profesor',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('id_materia', models.ForeignKey(on_delete=django.db.models.deletion.DO_NOTHING, to='institucion.Materia')),
            ],
        ),
        migrations.AddField(
            model_name='usuario',
            name='id_profesor',
            field=models.ForeignKey(default=0, on_delete=django.db.models.deletion.DO_NOTHING, to='usuario.Profesor'),
            preserve_default=False,
        ),
    ]