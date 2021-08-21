from django.shortcuts import render
from django.views.generic import CreateView
from apps.institucion.models import Materia

# Create your views here.

def VistaSemana(request):
    pass

def VistaMes(request):
    pass

def VistaDia(request):
    lunes = Materia.objects.get(diaCursado = "Lunes")
    martes = Materia.objects.get(diaCursado = "Martes")
    miercoles = Materia.objects.get(diaCursado = "Miércoles")
    jueves = Materia.objects.get(diaCursado = "Jueves")
    viernes = Materia.objects.get(diaCursado = "Viernes")
    #Cada uno de los días es una lista de objetos que cumple la condición.
    dias = [lunes, martes, miercoles, jueves, viernes]

    context = {'dias': dias}

    return render(request, 'usuario/home.html', context)
