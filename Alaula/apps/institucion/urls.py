from django.urls import path
from .views import Home, Aulas, Materia, Aulas_Vista

urlpatterns = [
        path('',Aulas_Vista , name = "homeIns"),
        path('aulas', Aulas.as_view(), name = "aulas"),
]
