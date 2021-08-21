from django.shortcuts import render, redirect
from django.views.generic import CreateView, ListView
from .forms import AltaUsuario
from .models import Usuario
from django.urls import reverse_lazy
from django.contrib.auth import (authenticate, get_user_model, login, logout)


# Create your views here.

class Signup(CreateView):
	model = Usuario
	form_class = AltaUsuario
	template_name = 'prueba.html'
	success_url = reverse_lazy('usuario:signup')

'''
class Perfil(ListView):
	model = Usuario
	template_name = "usuario/perfil.html"
	success_url = reverse_lazy('usuario:perfil')

'''
def Perfil(request):
	context = Usuario.objects.get(id = 1)
	user = {'username':context}

	return render(request, "usuario/perfil.html", user)

'''

def login_view(request):
	next = request.GET.get('next')
	form = UserLoginForm(request.POST or None)
	if form.is_valid():
		username = form.cleaned_data.get('username')
		password = form.cleaned_data.get('password')
		user = authenticate(username= username, password = password)
		login(request, user)

		if next:
			return redirect(next)
		return redirect('/')

	context = {
			'form': form,
	}
	return render(request, 'login.html',context)

'''
