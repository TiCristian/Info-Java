from django.db import models
from django.contrib.auth.models import AbstractUser
from apps.institucion.models import Anio, Materia


# Create your models here.
#Este modelo nos da la relacion que tiene un profesor con la materia que da
class Profesor(models.Model):
	id_materia = models.ForeignKey(Materia, on_delete = models.DO_NOTHING)

#Ésta clase representa a la tabla de usuario_alumno:
class Usuario(models.Model):
	username = models.CharField(max_length= 40, unique = True)
	password = models.CharField(max_length=80)
	email = models.EmailField(max_length=100)
	nombre = models.CharField(max_length=60)
	apellido = models.CharField(max_length=60)
	id_profesor = models.ForeignKey(Profesor, on_delete = models.DO_NOTHING)
	id_anio = models.ForeignKey(Anio, on_delete=models.DO_NOTHING)
