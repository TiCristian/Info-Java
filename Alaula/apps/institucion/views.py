from django.shortcuts import render, redirect
from django.http import HttpResponseRedirect
from django.views.generic import ListView, CreateView
from .models import Aula, Materia
from apps.usuario.models import Usuario

def Home(request):
    return render(request, 'institucion/home.html')

class Aulas(ListView):
    model = Aula
    template_name = "institucion/aula_list.html"


def Aulas_Vista(request):
    usuario = Usuario.objects.get(username = "Prueba")
    materias = Materia.objects.filter(id_anio = usuario.id_anio_id)


    context = {
                'materias': materias
    }

    return render(request, 'institucion/home.html', context)
