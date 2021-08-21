from django.db import models

# Create your models here.

#Ésta clase representa a la tabla de usuario_aula:
class Institucion(models.Model):
	nombre = models.CharField(primary_key=True, max_length=60)
	direccion = models.CharField(max_length=60)
	telefono = models.IntegerField()


class Aula(models.Model):
	id = models.IntegerField(primary_key=True)
	cantidadAlumnos = models.IntegerField()
	nombre = models.ForeignKey(Institucion, on_delete=models.DO_NOTHING)


class Anio(models.Model):
	id_anio = models.IntegerField(primary_key=True)

#Ésta clase representa a la tabla de usuario_materia:
class Materia(models.Model):
	nombre = models.CharField(primary_key=True, max_length=60)
	horarioCursado = models.DateTimeField()
	diaCursado = models.DateField()
	id_anio = models.ForeignKey(Anio, on_delete=models.DO_NOTHING)



#Ésta clase representa a la tabla de usuario_institucion:
