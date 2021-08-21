from django.shortcuts import render
from django.views.generic import CreateView
from django.views.generic.list import ListView
from django.views.generic.edit import DeleteView
from django.urls import reverse_lazy
from django.contrib.auth.decorators import login_required
from apps.usuario.models import Usuario



def home(request):
	return render(request, 'usuario/home.html')

def consultas(request):
	return render(request, 'usuario/consultas.html')

def perfil(request):
	return render(request, 'usuario/perfil.html')
