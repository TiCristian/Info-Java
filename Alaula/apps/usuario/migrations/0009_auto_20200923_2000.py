# Generated by Django 3.0 on 2020-09-23 23:00

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('usuario', '0008_usuario_anio'),
    ]

    operations = [
        migrations.RenameField(
            model_name='usuario',
            old_name='anio',
            new_name='id_anio',
        ),
    ]
