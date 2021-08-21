from django.contrib import admin
from .models import Aula, Materia, Anio, Institucion

# Register your models here.
admin.site.register(Aula)
admin.site.register(Materia)
admin.site.register(Anio)
admin.site.register(Institucion)