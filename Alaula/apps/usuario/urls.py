from django.urls import path
from .views import Signup, Perfil

urlpatterns = [
path('signup/',Signup.as_view(), name = "signup"),
path('perfil/', Perfil, name = 'perfil'),
]
